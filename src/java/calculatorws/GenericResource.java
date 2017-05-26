/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("calculate/{operation}")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    
    @GET
    @Produces("text/plain")
    public int get(@PathParam("operation") String operation,
            @QueryParam("x") int x,
            @QueryParam("y") int y) {
        int value = 0;
        
        switch(operation){
            case "add":
                value=x+y;
                break;
            case "sub":
                value=x-y;
                break;
            case "div":
                if(y==0)
                    value=0;
                else
                    value=x/y;
                break;
            case "mul":
                value=x*y;
                break;
        }
        
        return value;
    }
}
