package com.atlassian.uwc.converters.mediawiki;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MultilineBasicConverterTest extends TestCase {

	MultilineBasicConverter tester = null;
	Logger log = Logger.getLogger(this.getClass());
	protected void setUp() throws Exception {
		tester = new MultilineBasicConverter();
		PropertyConfigurator.configure("log4j.properties");
	}

	public void testConvertMultiline_ital() {
		String input, expected, actual;
		input = "''Testing\n" + 
				"sdkjfhskdjf''\n" + 
				"";
		expected = "_Testing_\n" + 
				"_sdkjfhskdjf_\n" + 
				"";
		actual = tester.convertMultiline(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	public void testConvertMultiline_bold() {
		String input, expected, actual;
		input = "'''Testing\n" + 
				"sdkjfhskdjf'''\n" + 
				"";
		expected = "*Testing*\n" + 
				"*sdkjfhskdjf*\n" + 
				"";
		actual = tester.convertMultiline(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	public void testConvertMultiline_both() {
		String input, expected, actual;
		input = "'''''Testing\n" + 
				"sdkjfhskdjf'''''\n" + 
				"";
		expected = "*_Testing_*\n" + 
				"*_sdkjfhskdjf_*\n" + 
				"";
		actual = tester.convertMultiline(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	public void testConvertMultiline_extraws() {
		String input, expected, actual;
		input = "  ''Testing\n" +
				"  asdasd  \n" + 
				"sdkjfhskdjf  ''\n" + 
				"";
		expected = "  _Testing_\n" +
				"_asdasd_\n" + 
				"_sdkjfhskdjf_\n" + 
				"";
		actual = tester.convertMultiline(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	public void testConvertMultiline_morewords() {
		String input, expected, actual;
		input = "123 ''Testing\n" + 
				"sdkjfhskdjf'' 456\n" + 
				"";
		expected = "123 _Testing_\n" + 
				"_sdkjfhskdjf_ 456\n" + 
				"";
		actual = tester.convertMultiline(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	public void testConvertMultiline_extralines() {
		String input, expected, actual;
		input = "''\n" +
				"Testing\n" + 
				"''\n" + 
				"";
		expected = "_Testing_\n" + 
				"\n";
		actual = tester.convertMultiline(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	public void testConvertMultiline_extraws2() {
		String input, expected, actual;
		input = "'''alskdalksjd\n" + 
				"  askdjaslkdj ''' aksjdh\n" + 
				"";
		expected = "*alskdalksjd*\n" + 
				"*askdjaslkdj* aksjdh\n" + 
				"";
		actual = tester.convertMultiline(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	
	


	public void testConvertMultiline_combo() {
		String input, expected, actual;
		input = "a '''''askjhd\n" + 
				"	aksjhdkajsdh'''''";
		expected = "a *_askjhd_*\n" + 
				"*_aksjhdkajsdh_*" + 
				"";
		actual = tester.convertMultiline(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}
	

}
