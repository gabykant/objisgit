package com.objis.serv;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.objis.impl.IEtudiant;
import com.objis.util.Etudiant;
import java.util.List;
import com.objis.db.DBConnexion;

public class Server implements IEtudiant{

	static DBConnexion con;

	public static void main(String[] args){
		try{
			Server obj = new Server();
			IEtudiant stub = (IEtudiant) UnicastRemoteObject.exportObject(obj, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("HelloEtudiant", stub);
			
			System.out.println("Bonjour \n Je suis a votre ecoute ...");
		} catch (Exception e) {
			System.err.println("Serveur exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public void saveEtudiant(Etudiant e){
		con.insert_element(e);
	}
	public void editEtudiant(int id) {
		con.delete_element(id);
	}
	public void updateEtudiant(Etudiant e) {
		con.update_element(e);
	}
	public List<Etudiant> listEtudiant() {
		return con.list_element();
	}
}