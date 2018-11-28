package cn.ch.netem.exceptions;

public class NoActivationException extends RuntimeException {
	@Override
	public String getMessage() {
		return "账户没有激活";
	}
}
