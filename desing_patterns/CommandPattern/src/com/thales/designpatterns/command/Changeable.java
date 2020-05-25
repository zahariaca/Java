package com.thales.designpatterns.command;


public interface Changeable {

	/**

	 * Undoes an action

	 */

	public void undo();

	

	/**

	 * Redoes an action

	 */

	public void redo();

}

