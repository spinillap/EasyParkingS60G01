
package restful.resource;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.model.UsuarioModel;
import restful.service.UsuarioService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
/**
 *
 * @author afmur
 */
@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    UsuarioService servicio = new UsuarioService();

    @GET
    public ArrayList<UsuarioModel> getUsuarios() {

        return servicio.getUsuarios();
    }

    @Path("/{UsuarioId}")
    @GET
    public UsuarioModel getUsuario(@PathParam("UsuarioId") String id) {

        return servicio.getUsuario(id);
    }

    @POST
    public UsuarioModel addUsuario(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UsuarioModel usuario = gson.fromJson(JSON, UsuarioModel.class);
        return servicio.addUsuario(usuario);
    }

    @DELETE
    @Path("/{UsuarioId}")
    public String delUsuario(@PathParam("UsuarioId") String id) {

        return servicio.delUsuario(id);

    }

    @PUT
    public UsuarioModel updateUsuario(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        UsuarioModel usuario = gson.fromJson(JSON, UsuarioModel.class);
        return servicio.updateUsuario(usuario);
    }
}
