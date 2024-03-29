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
		int valueCounter = 0;

		if (leistung == 0.0) {
		    valueCounter++;
        }
        if (spannung == 0.0) {
            valueCounter++;
        }
        if (strom == 0.0) {
            valueCounter++;
        }
        if (widerstand == 0.0){
            valueCounter++;
        }

        if (valueCounter < 2) {
            System.out.println("more than two Fields have a value");
        }
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

		else if (widerstand == 0.0 && leistung == 0.0 && spannung != 0.0 && strom != 0.0) {
			widerstand = RAusUundI(spannung, strom);
			leistung = pAusUundI(spannung, strom);
		}

		else if (widerstand != 0.0 && leistung != 0.0 && spannung == 0.0 && strom == 0.0) {
			spannung = uAusPundR(leistung, widerstand);
			strom = iAusPundR(leistung, widerstand);
		}

	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	public double pAusUundI(double u, double i) {
        System.out.println("Berechne Leistung aus Spannung und Strom");
		return u*i;
	}

	public double pAusRUndI(double r, double i) {
        System.out.println("Berechne Leistung aus Widerstand und Strom");
		return r * (i * i);
	}

	public double pAusUUndR(double u, double r) {
        System.out.println("Berechne Leistung aus Spannung und Widerstand");
		return  (u * u) / r;
	}
    public double uAusRundI(double r, double i) {
        System.out.println("Berechne Spannung aus Widerstand und Strom");
        return r*i;
    }
    public double uAusPundI(double p, double i) {
        System.out.println("Berechne Spannung aus Leistung und Strom");
        return p/i;
    }
    public double uAusPundR(double p, double r) {
        System.out.println("Berechne Spannung aus Leistung und Widerstand");
        return Math.sqrt(p*r);
    }
	public double iAusPundR(double p, double r) {
        System.out.println("Berechne Strom aus Leistung und Widerstand");
		return Math.sqrt(p/r);
	}
	public double iAusPundU(double p, double u) {
        System.out.println("Berechne Strom aus Leistung und Spannung");
		return p/u;
	}
	public double iAusUundR(double u, double r) {
        System.out.println("Berechne Strom aus Spannung und Widerstand");
		return u/r;
	}
    public double RAusUundP(double u, double p) {
        System.out.println("Berechne Widerstand aus Spannung und Leistung");
        return (u*u)/p;
    }
    public double RAusPundI(double p, double i) {
        System.out.println("Berechne Widerstand aus Leistung und Strom");
        return p/(i*i);
    }
    public double RAusUundI(double u, double i) {
        System.out.println("Berechne Widerstand aus Spannung und Strom");
        return u/i;
    }
}
