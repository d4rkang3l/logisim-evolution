/*******************************************************************************
 * This file is part of logisim-evolution.
 *
 *   logisim-evolution is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   logisim-evolution is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with logisim-evolution.  If not, see <http://www.gnu.org/licenses/>.
 *
 *   Original code by Carl Burch (http://www.cburch.com), 2011.
 *   Subsequent modifications by :
 *     + Haute École Spécialisée Bernoise
 *       http://www.bfh.ch
 *     + Haute École du paysage, d'ingénierie et d'architecture de Genève
 *       http://hepia.hesge.ch/
 *     + Haute École d'Ingénierie et de Gestion du Canton de Vaud
 *       http://www.heig-vd.ch/
 *   The project is currently maintained by :
 *     + REDS Institute - HEIG-VD
 *       Yverdon-les-Bains, Switzerland
 *       http://reds.heig-vd.ch
 *******************************************************************************/

package com.bfh.logisim.fpgaboardeditor;

import java.util.Iterator;
import java.util.LinkedList;

public class FPGAClass {
	public static char getId(String identifier) {
		char result = 0;
		LinkedList<String> thelist = FPGAClass.getStrings();
		Iterator<String> iter = thelist.iterator();
		result = 0;
		while (iter.hasNext()) {
			if (iter.next().toUpperCase().equals(identifier.toUpperCase()))
				return result;
			result++;
		}
		return VendorUnknown;
	}

	public static LinkedList<String> getStrings() {
		LinkedList<String> result = new LinkedList<String>();

		result.add(Vendors[0]);
		result.add(Vendors[1]);

		return result;
	}

	public static char VendorAltera = 0;
	public static char VendorXilinx = 1;
	public static char VendorUnknown = 255;
	public static String[] Vendors = { "Altera", "Xilinx" };
	private long ClockFrequency;
	private String ClockPinLocation;
	private char ClockPullBehavior;
	private char ClockIOStandard;
	private String Technology;
	private String Part;
	private String Package;
	private String SpeedGrade;
	private char Vendor;
	private char UnusedPinsBehavior;
	private boolean FPGADefined;

	private boolean USBTMCDownload;

	private int JTAGPos;

	public FPGAClass() {
		ClockFrequency = 0;
		ClockPinLocation = null;
		ClockPullBehavior = 0;
		ClockIOStandard = 0;
		Technology = null;
		Part = null;
		Package = null;
		SpeedGrade = null;
		Vendor = 0;
		FPGADefined = false;
		UnusedPinsBehavior = 0;
		USBTMCDownload = false;
		JTAGPos = 1;
	}

	public void clear() {
		ClockFrequency = 0;
		ClockPinLocation = null;
		ClockPullBehavior = 0;
		ClockIOStandard = 0;
		Technology = null;
		Part = null;
		Package = null;
		SpeedGrade = null;
		Vendor = 0;
		FPGADefined = false;
		UnusedPinsBehavior = 0;
		USBTMCDownload = false;
		JTAGPos = 1;
	}

	public boolean FpgaInfoPresent() {
		return FPGADefined;
	}

	public long getClockFrequency() {
		return ClockFrequency;
	}

	public String getClockPinLocation() {
		return ClockPinLocation;
	}

	public char getClockPull() {
		return ClockPullBehavior;
	}

	public char getClockStandard() {
		return ClockIOStandard;
	}

	public String getPackage() {
		return Package;
	}

	public String getPart() {
		return Part;
	}

	public String getSpeedGrade() {
		return SpeedGrade;
	}

	public String getTechnology() {
		return Technology;
	}

	public char getUnusedPinsBehavior() {
		return UnusedPinsBehavior;
	}

	public char getVendor() {
		return Vendor;
	}

	public int JTAGChainPosition() {
		return JTAGPos;
	}

	public void Set(long frequency, String pin, String pull, String standard,
			String tech, String device, String box, String speed, String vend,
			String unused, boolean UsbTmc, String JTAGPos) {
		ClockFrequency = frequency;
		ClockPinLocation = pin;
		ClockPullBehavior = PullBehaviors.getId(pull);
		ClockIOStandard = IoStandards.getId(standard);
		Technology = tech;
		Part = device;
		Package = box;
		SpeedGrade = speed;
		Vendor = getId(vend);
		FPGADefined = true;
		UnusedPinsBehavior = PullBehaviors.getId(unused);
		USBTMCDownload = UsbTmc;
		this.JTAGPos = Integer.valueOf(JTAGPos);
	}

	public Boolean USBTMCDownloadRequired() {
		return USBTMCDownload;
	}
}