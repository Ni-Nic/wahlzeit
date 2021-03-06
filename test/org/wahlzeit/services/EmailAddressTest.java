/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import org.wahlzeit.utils.StringUtil;

import junit.framework.*;

/**
 * 
 * @author dirkriehle
 * 
 */
public class EmailAddressTest extends TestCase {

	/**
	 * 
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(EmailAddressTest.class);
	}

	/**
	 * 
	 */
	public EmailAddressTest(String name) {
		super(name);
	}

	/**
	 * 
	 */
	public void testGetEmailAddressFromString() {
		assertFalse(createEmailAddressIgnoreException("bingo"));
		assertFalse(createEmailAddressIgnoreException("bingo@bongo@bingo"));
		assertFalse(createEmailAddressIgnoreException("bingo.bongo"));
		assertFalse(createEmailAddressIgnoreException("..."));
		assertFalse(createEmailAddressIgnoreException("@45@!52"));

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));		
	}
	
	/**
	 * 
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 * 
	 */
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}

}

