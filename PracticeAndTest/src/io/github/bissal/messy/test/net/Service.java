package io.github.bissal.messy.test.net;
import io.github.bissal.messy.entity.IEntity;


public class Service implements IEntity {
	private String name;
	
	private Connector connector01;
	private Connector connector02;
	
	public Service(String name) {
		this.setName(name);
	}

	public Service() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Connector getConnector01() {
		return connector01;
	}

	public void setConnector01(Connector connector01) {
		this.connector01 = connector01;
	}

	public Connector getConnector02() {
		return connector02;
	}

	public void setConnector02(Connector connector02) {
		this.connector02 = connector02;
	}
}
