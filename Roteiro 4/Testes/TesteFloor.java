class FloorBinarySearchTestes {

    private FloorBinarySearchImpl implementacao;
    private Integer[] array;
    private Integer[] arrayOrdenado;
    private Integer[] arrayVazio;
    
    @BeforeEach
    void preparaArrays() {
        this.implementacao = new FloorBinarySearchImpl();
        this.array = new Integer[] {10, 27, -10, -5, 12, 100, 25, -20};
        this.arrayOrdenado = new Integer[] {-20, -10, -5, 10, 12, 25, 27, 100};
        this.arrayVazio = new Integer[] {};
    }
    
    @Test
    void testaOrdenacao() {
        this.implementacao.floor(array, 12);
        assertTrue(Arrays.equals(array, arrayOrdenado));
    }
    
    @Test
    void testaArrayVazio() {
        int result = this.implementacao.floor(arrayVazio, -10);
        assertEquals(-1, result);
    }
    
@Test
    void testaArray01() {
        int result = this.implementacao.floor(array, -20);
        assertEquals(-20, result);
    }
    
    @Test
    void testaArray02() {
        int result = this.implementacao.floor(array, 100);
        assertEquals(100, result);
    }
    
    @Test
    void testaArray03() {
        int result = this.implementacao.floor(array, 11);
        assertEquals(10, result);
    }
}
