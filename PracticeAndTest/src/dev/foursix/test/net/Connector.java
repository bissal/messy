package dev.foursix.test.net;
import dev.foursix.entity.IEntity;


public class Connector implements IEntity {
	private int port;
	private String protocol;
	private int connectionTimeout;
	private int redirectPort;

	public Connector(int port, String protocol,
			int connectionTimer, int redirectPort) {
		this.setPort(port);
		this.setProtocol(protocol);
		this.setConnectionTimeout(connectionTimer);
		this.setRedirectPort(redirectPort);		
	}
	
	public Connector(int port, String protocol, int redirectPort) {
		this(port, protocol, -1, redirectPort);
	}

	public Connector() {
		// TODO Auto-generated constructor stub
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getRedirectPort() {
		return redirectPort;
	}

	public void setRedirectPort(int redirectPort) {
		this.redirectPort = redirectPort;
	}
}
