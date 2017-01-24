package Models.Business;

import Beans.User;

import javax.ejb.Local;

@Local
public interface SessionBusinessLocal {
    User login(String user, String password);
}
