package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
		if(widerstand != 0.0 && leistung != 0.0 && spannung == 0.0 && strom == 0.0) {
			widerstand = RAusUundP(spannung, leistung);
			strom = iAusPundU(leistung, spannung);
		}

		else if (widerstand != 0.0 && leistung == 0.0 && spannung != 0.0 && strom == 0.0) {
			leistung = pAusUUndR(spannung, widerstand);
			strom = iAusUundR(spannung, widerstand);
		}

		else if (widerstand != 0.0 && leistung == 0.0 && spannung == 0.0 && strom != 0.0) {
			spannung = uAusRundI(widerstand, strom);
			leistung = pAusRUndI(widerstand, strom);
		}

		else if (widerstand == 0.0 && leistung != 0.0 && spannung == 0.0 && strom != 0.0) {
			widerstand = RAusPundI(leistung, strom);
			spannung = uAusPundI(leistung, strom);
		}

		

	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	public double pAusUundI(double u, double i) {
		double p = u*i;
		return p;
	}

	public double pAusRUndI(double r, double i) {
		double p = i * i * r;
		return p;
	}

	public double pAusUUndR(double u, double r) {
		double p = u * u / r;
		return p;
	}
    public double uAusRundI(double r, double i) {
        return r*i;
    }
    public double uAusPundI(double p, double i) {
        return p/i;
    }
    public double uAusPundR(double p, double r) {
        return Math.sqrt(p*r);
    }
	public double iAusPundR(double p, double r) {
		return Math.sqrt(p/r);
	}
	public double iAusPundU(double p, double u) {
		return p/u;
	}
	public double iAusUundR(double u, double r) {
		return u/r;
	}
    public double RAusUundP(double u, double p) {
        return u*u/p;
    }
    public double RAusPundI(double p, double i) {
        return p/i*i;
    }
    public double RAusUundI(double u, double i) {
        return u/i;
    }
}
