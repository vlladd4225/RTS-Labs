class Calculator {
    private double real;
    private double imaginary;

    public Calculator(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Calculator add(Calculator other) {
        return new Calculator(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Calculator subtract(Calculator other) {
        return new Calculator(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Calculator multiply(Calculator other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new Calculator(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        return real + (imaginary < 0 ? " - " : " + ") + Math.abs(imaginary) + "i";
    }
}