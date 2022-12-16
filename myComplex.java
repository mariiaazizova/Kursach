package myPCG_Complex;

public class myComplex {
	private float im;
	private float re;
	public myComplex() {						// конструктор без параметров
		im=0; re=0; 
		}
	public myComplex(float _im, float _re) {	// конструктор с параметрами
		im=_im; re=_re; 
		}
	public myComplex(myComplex _comp) {			// конструктор копирования
		im=_comp.im; re=_comp.re; 
		}
	public void set(float re1, float im1) {		// конструктор изменения
		re = re1;
		im = im1;
		}

	public void sqr(myComplex z, myComplex c) {
		float re1 = re;
		re = re*re - im*im + c.re;
		im = 2*re1*im + c.im;
	}

	public float norm() {
		return re*re +im*im;
	}
	public float re() { return this.re; }
	public float im() { return this.im; }
	
}
