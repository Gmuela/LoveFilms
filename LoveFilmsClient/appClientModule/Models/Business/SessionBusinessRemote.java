package Models.Business;

import Beans.User;

import javax.ejb.Remote;

@Remote
public interface SessionBusinessRemote {
    User login(String user, String password);
}
