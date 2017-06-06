package hb.asserts;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class MatcherUser extends TypeSafeMatcher<User> {
	private User userExpected;
	private MatcherUser(User userExpected) {this.userExpected = userExpected;}
	@Override
	public void describeTo(Description description) {
		description.appendValue(userExpected);
	}
	@Override
	protected boolean matchesSafely(User itemUser){
		if(itemUser.getPassword().equals(userExpected.getPassword())){
			return true;
		}else{
			return false;
		}
	}
	public static MatcherUser myEquals (User userExpected) {
		return new MatcherUser (userExpected);
	}
}