package com.demetrius.projetoFuji.model;

public enum Status
{
	ABERTO(1),
	FECHADO(2);
	
	public int valStatus;
	
	Status(int val){
		valStatus=val;
	}
}
