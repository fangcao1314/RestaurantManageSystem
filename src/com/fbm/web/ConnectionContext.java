package com.fbm.web;

import java.sql.Connection;

public class ConnectionContext {

	public ConnectionContext() {}

	public static ConnectionContext instance = new ConnectionContext();
	
	public static ConnectionContext getInstance(){
		return instance;
	}
	
	
	private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

	public void bind(Connection connection) {
		connectionThreadLocal.set(connection);
	}

	public Connection get() {
		return connectionThreadLocal.get();
	}

	public void remove() {
		connectionThreadLocal.remove();
	}
}
