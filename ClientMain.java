package com.objis.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.objis.impl.IEtudiant;
import java.util.List;
import com.objis.util.Etudiant;

public class ClientMain{

	public static void main(String[] args){
		Etudiant etudiant = new Etudiant();
		String host = (args.length < 1) ? null : args[0];
		if(args[1] != null) etudiant.setNom(args[1]);
		if(args[2] != null) etudiant.setPrenom(args[2]);

System.out.println(etudiant);

		try{
			Registry registry = LocateRegistry.getRegistry(host);
			IEtudiant stub = (IEtudiant) registry.lookup("HelloEtudiant");
			stub.saveEtudiant(etudiant);
			List<Etudiant> etudiants = stub.listEtudiant();
			for(Etudiant e : etudiants){
				System.out.println(e);
			}
		} catch (Exception e){
			System.out.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}