package com.el_economico.api.service.impl;

import com.el_economico.api.client.ClientIntern;
import com.el_economico.api.model.DTO.POST.PedidoPOST;
import com.el_economico.api.model.DTO.REQUEST.CabeceraPedidoReq;
import com.el_economico.api.model.DTO.REQUEST.PedidoCabeceraContactReq;
import com.el_economico.api.model.DTO.REQUEST.PedidoReq;
import com.el_economico.api.model.DTO.REQUEST.ProductoPedidoReq;
import com.el_economico.api.model.common.ApiResponse;
import com.el_economico.api.model.mapper.PedidoReqMapper;
import com.el_economico.api.repository.PedidosRepository;
import com.el_economico.api.service.PedidosService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class PedidosServiceImpl implements PedidosService {

    private final ClientIntern client;
    private final PedidoReqMapper mapper;
    private final PedidosRepository repository;

    public PedidosServiceImpl(ClientIntern client, @Lazy PedidoReqMapper mapper, @Lazy PedidosRepository repository){
        this.client = client;
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public ResponseEntity<ApiResponse> getAll() {
        List<PedidoReq> pedidos = mapper.toPedidoReq(this.repository.getAll());
        List<String> msg = List.of("Registros encontrados");
        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, msg, pedidos));
    }

    @Override
    public ResponseEntity<ApiResponse> insertPedido(PedidoPOST e) {
        try{
            this.repository.pedidosInsert(e.getIdUsuario(), e.getIdCliente(), e.getProductos().get(0).getIdProducto(),
                    e.getDestino(), e.getProductos().get(0).getCantidad(), e.getProductos().get(0).getMonto(),
                    e.getImpuesto(), e.getSubtotal(), e.getEnvio(), e.getTotal(),
                    e.getEstadoPedido(), e.getCreadoPor(), e.getEstado());
            int id = this.repository.pedidoLastId();
            for(int i = 1; i < e.getProductos().size(); i++){
                this.repository.pedidosInsertC(id, e.getIdUsuario(), e.getIdCliente(), e.getProductos().get(i).getIdProducto(),
                        e.getDestino(), e.getProductos().get(i).getCantidad(), e.getProductos().get(i).getMonto(), e.getImpuesto(), e.getSubtotal(),
                        e.getEnvio(), e.getTotal(), e.getEstadoPedido(), e.getCreadoPor(), e.getEstado());
            }
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.CREATED, List.of("Registro insertado"), null));
        }catch(Exception ex){
            return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.NOT_ACCEPTABLE, List.of("Registro no insertado"), null));
        }
    }

    @Override
    public ResponseEntity getPedidoById(int id) {
        List<Object[]> lista = this.repository.pedidosGetByClient(id);
        List<CabeceraPedidoReq> listaFilter = new ArrayList<>();
        for(int i = 0; i < lista.size(); i++){
            CabeceraPedidoReq cabecera = new CabeceraPedidoReq();
            cabecera.setPedido_numero((int) lista.get(i)[0]);
            cabecera.setUsuario((String) lista.get(i)[1]);
            cabecera.setCliente((String) lista.get(i)[2]);
            cabecera.setTotal((float) lista.get(i)[3]);
            cabecera.setEstado_pedido((String) lista.get(i)[4]);
            listaFilter.add(cabecera);
        }
        if(lista.size() > 0){
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Registros encontrados"), listaFilter));
        }
        return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.NOT_FOUND, List.of("No tiene Pedidos Activos"), null));
    }

    @Override
    public ResponseEntity getDetallePedido(int pedidoNumero) {
        List<Object[]> list = this.repository.getDetallesPedido(pedidoNumero);
        List<ProductoPedidoReq> listFilter = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            byte[] imageByte = (byte[]) list.get(i)[4];
            String image = Base64.getEncoder().encodeToString(imageByte);
            ProductoPedidoReq producto = new ProductoPedidoReq().builder()
                    .NombreProducto((String) list.get(i)[3])
                    .Imagen(image)
                    .Precio((float) list.get(i)[5])
                    .Cantidad((int) list.get(i)[6])
                    .Monto((float) list.get(i)[7])
                    .build();
            listFilter.add(producto);
        }
        PedidoReq pedido = new PedidoReq().builder()
                .NumeroPedido((int) list.get(0)[0])
                .Usuario((String) list.get(0)[1])
                .Cliente((String) list.get(0)[2])
                .Destino((String) list.get(0)[9])
                .productos(listFilter)
                .Total((float) list.get(0)[8])
                .Estado((String) list.get(0)[10])
                .build();

        List<PedidoReq> listPedido = List.of(pedido);

        return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Registros encontrados"), listPedido));
    }

    @Override
    public ResponseEntity getPedidosUnsigned() {
        List<Object[]> list = this.repository.getPedidosUnsigned();
        List<CabeceraPedidoReq> listFilter = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            CabeceraPedidoReq cabecera = new CabeceraPedidoReq();
            cabecera.setPedido_numero((int) list.get(i)[0]);
            cabecera.setUsuario((String) list.get(i)[1]);
            cabecera.setCliente((String) list.get(i)[2]);
            cabecera.setTotal((float) list.get(i)[3]);
            cabecera.setEstado_pedido((String) list.get(i)[4]);
            listFilter.add(cabecera);
        }
        if(listFilter.size() > 0){
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Registros encontrados"), listFilter));
        }
        return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.NOT_FOUND, List.of("No tiene Pedidos sin firmar"), null));
    }

    @Override
    public ResponseEntity getCabeceraPedido(int pedidoNumero) {
        List<Object[]> list = this.repository.getCabeceraPedido(pedidoNumero);
        List<PedidoCabeceraContactReq> listFilter = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            PedidoCabeceraContactReq cabecera = new PedidoCabeceraContactReq();
            cabecera.setPedidoNumero((int) list.get(i)[0]);
            cabecera.setCliente((String) list.get(i)[1]);
            cabecera.setTelefono((String) list.get(i)[2]);
            cabecera.setUbicacion((String) list.get(i)[3]);
            cabecera.setTotal((float) list.get(i)[4]);
            listFilter.add(cabecera);
        }
        if(listFilter.size() > 0){
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Registros encontrados"), listFilter));
        }
        return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.NOT_FOUND, List.of("No tiene Pedidos sin firmar"), null));
    }

    @Override
    public ResponseEntity getAllPedidoForRepartidor(int idUsuario) {
        List<Object[]> list = this.repository.getAllPedidoForRepartidor(idUsuario);
        List<CabeceraPedidoReq> listFilter = new ArrayList<>();
        for (Object[] objects : list) {
            CabeceraPedidoReq cabecera = new CabeceraPedidoReq();
            cabecera.setPedido_numero((int) objects[0]);
            cabecera.setUsuario((String) objects[1]);
            cabecera.setCliente((String) objects[2]);
            cabecera.setTotal((float) objects[3]);
            cabecera.setEstado_pedido((String) objects[4]);
            listFilter.add(cabecera);
        }
        if(!listFilter.isEmpty()){
            return ResponseEntity.ok().body(new ApiResponse(HttpStatus.OK, List.of("Registros encontrados"), listFilter));
        }
        return ResponseEntity.badRequest().body(new ApiResponse(HttpStatus.NOT_FOUND, List.of("No tiene Pedidos sin firmar"), null));
    }
}
