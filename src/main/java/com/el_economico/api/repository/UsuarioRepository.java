package com.el_economico.api.repository;


import com.el_economico.api.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Procedure("usuariosGetAll")
    List<Usuario> getAll();

    @Procedure("usuariosInsert")
    void usuarioInsert(@Param("i_nombres")String nombres,@Param("i_apellidos")String apellidos,
                       @Param("i_dni") String dni,@Param("i_fecha_nac") Date fecha_nac,@Param("i_genero") Character genero,
                       @Param("i_correo") String correo,@Param("i_telefono") String telefono,@Param("i_foto") String foto,
                       @Param("i_usuario") String usuario,@Param("i_passwrd") String passwd,@Param("i_id_rol") Integer rol,
                       @Param("i_creado_por") String creado_por,@Param("i_estado") Integer estado);

    @Procedure("usuariosPut")
    void usuarioPut(@Param("p_nombres") String nombres,@Param("p_apellidos") String apellidos,
                    @Param("p_dni") String dni,@Param("p_fecha_nac") Date fecha_nac,@Param("p_genero") Character genero,
                    @Param("p_correo") String correo,@Param("p_telefono") String telefono,@Param("p_foto") String foto,
                    @Param("p_usuario") String usuario,@Param("p_passwrd") String passwd,@Param("p_id_rol") Integer rol,
                    @Param("p_modificado_por") String modificado_por,@Param("p_estado") Integer estado,@Param("p_id") Integer id);

    @Procedure("usuariosChangeStatus")
    void usuarioChangeStatus(@Param("c_modificado_por") String modificado_por,@Param("c_estado") Integer estado, @Param("c_id") Integer id);
}
