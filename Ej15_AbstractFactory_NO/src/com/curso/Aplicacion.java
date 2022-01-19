package com.curso;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

public class Aplicacion extends SimpleApplication {
	 
    public static void main(String[] args) {
 
    	Aplicacion app = new Aplicacion();
 
        AppSettings settings = new AppSettings(true);
        settings.setTitle("My Awesome Game");
        app.setSettings(settings);
 
        app.start();
 
    }
 
    @Override
    public void simpleInitApp() {
 
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);
 
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);
 
        rootNode.attachChild(geom);
 
    }
 
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }
 
}
