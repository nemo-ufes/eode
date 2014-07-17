package br.ufes.inf.nemo.odercp.rcpapp.userControl.cpd;

/**
 * 
 * @author Danillo Ricardo Celino (drcelino@inf.ufes.br)
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;

public class Feature {

	private String name;

	private String path = null;

	private boolean avaliableonlytoOpenProjects = false;

	private List<Feature> subfeatures = new ArrayList<Feature>();

	private List<AcessProfile> permissoins = new ArrayList<AcessProfile>();

	public Feature(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isAvaliableonlytoOpenProjects() {
		return avaliableonlytoOpenProjects;
	}

	public void setAvaliableonlytoOpenProjects(boolean avaliableonlytoOpenProjects) {
		this.avaliableonlytoOpenProjects = avaliableonlytoOpenProjects;
	}

	public List<Feature> getSubfeatures() {
		return subfeatures;
	}

	public void setSubfeatures(List<Feature> subfeatures) {
		this.subfeatures = subfeatures;
	}

	public List<AcessProfile> getPermissoins() {
		return permissoins;
	}

	public void setPermissoins(List<AcessProfile> permissoins) {
		this.permissoins = permissoins;
	}

}
