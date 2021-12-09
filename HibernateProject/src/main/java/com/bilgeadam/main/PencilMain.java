package com.bilgeadam.main;

import com.bilgeadam.controller.PencilController;
import com.bilgeadam.egitim.enumx.EPencil;
import com.bilgeadam.entity.PencilEntity;

public class PencilMain {
	public static void main(String[] args) {
		PencilEntity pencilEntity = new PencilEntity();
		pencilEntity.setPencilName("Adel 44");
		pencilEntity.setPencilBrand("Rotring");
		pencilEntity.setPencilType(EPencil.TukenmezKalem);
		
		PencilController pencilController = new PencilController();
		pencilController.create(pencilEntity);
		
	}
}
