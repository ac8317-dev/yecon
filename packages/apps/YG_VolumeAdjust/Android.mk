ifeq ($(BOARD_USES_YECON_NEWUI),false)
LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under, src)

#LOCAL_JAVA_LIBRARIES := autochips

LOCAL_PACKAGE_NAME := YG_VolumeAdjust
LOCAL_CERTIFICATE := platform

include $(BUILD_PACKAGE)
endif