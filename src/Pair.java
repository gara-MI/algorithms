import java.io.Serializable;

/*public class Pair<L,R> {
	public final L first;
	public final R second;
	public Pair(L first, R second){
		this.first = first;
		this.second = second;
	}
	
	@Override
	public boolean equals(Object object){
		if( object instanceof Pair){
			final Pair pair = (Pair)object;
			return this.first.equals(pair.first) && this.second.equals(pair.second); 
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		
	}
}*/
public class Pair< K, V > implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	K first;
    V second;

    public Pair( K key, V value )
    {
        this.first   = key;
        this.second = value;
    }

    public Pair( Pair< K, V > tuple )
    {
        this.first   = tuple.getFirst();
        this.second = tuple.getSecond();
    }

    public K getFirst()   { return this.first; }
    public V getSecond() { return this.second; }

    /**
     * The importance of this method is to ensure that tuples, which are key-value
     * pairs, are examined for equality not by their object reference, but by their
     * content. Of course, for optimization sake, if the object references match,
     * then there's no need to compare the strings character by character.
     */
    public boolean equals( Object o )
    {
        if( !( o instanceof Tuple ) )
            return false;

        @SuppressWarnings( "unchecked" )
        Pair< K, V > pair = ( Pair< K, V > ) o;
        K             first   = pair.getFirst();
        V             second = pair.getSecond();

        return ( ( first == this.first && second == this.second )
                || first.equals( this.first ) && second.equals( this.second ) );
    }
}