package com.matter.virtual.device.app

import timber.log.Timber

class TimberDebugTree : Timber.DebugTree() {
  override fun createStackElementTag(element: StackTraceElement): String {
    return if (BuildConfig.DEBUG) {
      "[VirtualDeviceApp]:${element.fileName}:${element.lineNumber}#${element.methodName}"
    } else {
      "[VirtualDeviceApp]:${element.className}#${element.methodName}"
    }
  }
}
