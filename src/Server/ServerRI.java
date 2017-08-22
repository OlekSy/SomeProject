package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRI extends Remote{
    String sayHello() throws RemoteException;
}
