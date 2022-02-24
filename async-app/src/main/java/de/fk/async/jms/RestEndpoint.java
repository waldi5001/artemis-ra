package de.codedoor.async.workshop.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.ConnectionFactory;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import javax.naming.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Stateless
@Path("/")
public class RestEndpoint {

    private static final void listContext(Context ctx, String indent) throws NamingException {
        NamingEnumeration list = ctx.listBindings("");
        while (list.hasMore()) {
            Binding item = (Binding) list.next();
            String className = item.getClassName();
            String name = item.getName();
            System.out.println(name + ": " + className);
            Object o = item.getObject();
            if (o instanceof javax.naming.Context) {
                listContext((Context) o, indent + " ");
            }
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getEntities() {
        try {
            Context ctx = (Context) new InitialContext().lookup("java:comp/env");
            listContext(ctx, "");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(asList("1", "2"));
    }
}