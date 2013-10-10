package br.com.fiap.estoque.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;


@Component
@Path("service-exemplo")
public class ServiceExemploResource {
	
	
	@GET
	@Path("/metodo")
	public Response metodoRest() {
		return Response.status(200).entity("Retorno").build();
	}

}
