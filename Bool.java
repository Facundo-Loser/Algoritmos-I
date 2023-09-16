package Boolean;

public interface Bool {

	public Bool true0();

	public Bool false0();

	public Bool not();

	public Bool or(Bool q);

	public Bool imp(Bool q);

	public int getNatBool();

	@Override
	public String toString();
}