package com.ivan.jmh.strings;

import org.openjdk.jmh.annotations.*;

import java.text.MessageFormat;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class FormattingTest {

//    Benchmark                      Mode  Cnt          Score         Error  Units
//    FormattingTest.concatenation  thrpt   15  223284745,019 ± 6250482,690  ops/s
//    FormattingTest.messageFormat  thrpt   15    1192160,890 ±   39922,854  ops/s
//    FormattingTest.stringFormat   thrpt   15     704338,071 ±   20225,003  ops/s

    @Benchmark
    public String concatenation() {
        return "Today is " + "Tuesday" + ". My name is " + "Ivan" + ". Welcome to " + "Karaganda" + "!";
    }

    @Benchmark
    public String stringFormat() {
        return String.format("Today is %s. My name is %s. Welcome to %s.", "Tuesday", "Ivan", "Karaganda");
    }

    @Benchmark
    public String messageFormat() {
        return MessageFormat.format("Today is {0}. My name is {1}. Welcome to {2}.", "Tuesday", "Ivan", "Karaganda");
    }

}
