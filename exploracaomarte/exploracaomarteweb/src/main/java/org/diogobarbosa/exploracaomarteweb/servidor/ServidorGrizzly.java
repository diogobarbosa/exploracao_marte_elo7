package org.diogobarbosa.exploracaomarteweb.servidor;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class ServidorGrizzly {

	public static void main(String[] args) throws IOException {
		
        HttpServer server = inicializaServidor();
        System.out.println("Servidor rodando");
        System.in.read();
        server.shutdown();
    }
	
	public static HttpServer inicializaServidor() {
	    ResourceConfig config = new ResourceConfig().packages("org.diogobarbosa.exploracaomarteweb");
	    URI uri = URI.create("http://localhost:8080/");
	    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
	    return server;
	}
}
