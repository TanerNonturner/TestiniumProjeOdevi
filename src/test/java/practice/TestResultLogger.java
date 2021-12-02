package practice;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import io.quarkus.logging.Log;

public class TestResultLogger implements TestWatcher {

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
		// TODO Auto-generated method stub
		TestWatcher.super.testDisabled(context, reason);
	}

	@Override
	public void testSuccessful(ExtensionContext context) {
	 String testName = context.getDisplayName();
	 Log.info(testName+"Passed");
	}

	@Override
	public void testAborted(ExtensionContext context, Throwable cause) {
		// TODO Auto-generated method stub
		TestWatcher.super.testAborted(context, cause);
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		String testName = context.getDisplayName();
		String testFailCause = cause.getMessage();
		Log.error(testName+" FAILED"+ " "+testFailCause);
	}
	

}
