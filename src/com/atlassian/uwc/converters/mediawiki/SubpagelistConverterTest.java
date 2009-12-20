package com.atlassian.uwc.converters.mediawiki;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SubpagelistConverterTest extends TestCase {

	SubpagelistConverter tester = null;
	Logger log = Logger.getLogger(this.getClass());
	protected void setUp() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		tester = new SubpagelistConverter();
	}
	
	public void testConvertSplist() {
		String input, expected, actual;
		input = "<splist parent=\"SampleMediawiki_InputSplist/Test\" showparent=\"no\" sort=\"asc\" " +
				"sortby=\"title\" liststyle=\"unordered\" showpath=\"no\" kidsonly=\"yes\" debug=\"0\"></splist>";
		expected = "{children:sort=title|page=SampleMediawiki_InputSplist Test}";
		actual = tester.convertSplist(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	public void testConvertSplist2() {
		String input, expected, actual;
		input = "<splist parent=\"SampleMediawiki_InputSplist\" showparent=\"no\" sort=\"asc\" " +
				"liststyle=\"unordered\" showpath=\"no\" kidsonly=\"yes\" debug=\"0\"></splist>";
		expected = "{children:sort=title|page=SampleMediawiki_InputSplist}";
		actual = tester.convertSplist(input);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

}
