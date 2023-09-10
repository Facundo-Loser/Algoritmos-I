package Vectores;

public interface Vector{

	public void multEscalar(int k);

	public void suma(Vector u);

	public Integer prodEscalar(Vector u);

	public int dimension();

	public Integer getComponente(int k);

	@Override
	public String toString();

	@Override
	public boolean equals(Object otroVector);
}