package org.jboss.as.quickstarts.ear;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest-ejb")
public class JaxRsActivatorEjb extends Application {
/*     protected Set<Object> singletons = new HashSet<Object>();

    public JaxRsActivatorEjb() {
        singletons.add(new Greeter());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    } */
}
