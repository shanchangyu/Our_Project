/**
 * 
 */
package com.thosepeople.constant;

/**
 * @author chenzhuo
 * 
 */
public enum InfoType {
	LOVE_INFO(1), JOB_INFO(2), HOUSE_INFO(3), ACTIVITY_INFO(4);
	int value;

	InfoType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static InfoType getInfoTypeByValue(int value) {
		for (InfoType it : InfoType.values()) {
			if (it.getValue() == value) {
				return it;
			}
		}
		return null;
	}
}
