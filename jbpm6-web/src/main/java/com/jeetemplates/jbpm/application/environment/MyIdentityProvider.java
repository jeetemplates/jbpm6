package com.jeetemplates.jbpm.application.environment;

import java.util.Collections;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.kie.internal.identity.IdentityProvider;

/**
 * @author paoesco
 */
@ApplicationScoped
public class MyIdentityProvider implements IdentityProvider {

    @Override
    public String getName() {
        return "name";
    }

    @Override
    public List<String> getRoles() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean hasRole(String role) {
        return true;
    }

}
