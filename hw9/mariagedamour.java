/**
 *
 * This file contains sheet music (mariage d'amour by Richard Clayderman)
 * coded in by a student, Johahn Wu
 * "There are some errors though, keep on having trouble syncing dotted notes."
 *
 * This code can be inserted at the bottom of the Cons.jfugue.java file,
 * ahead of the exit line, of course.
 */

Cons ent3 = readlist( list (
"(seq (rest 60)(piano 0 G6 4) (piano 0 G6 4) (piano 0 A6 4) (piano 0 A6 4)(piano 0 Bb6 4)(piano 0 Bb6 4)(piano 0 A6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 G6 4)(piano 0 D6 4)(piano 0 D6 4)(piano 0 Bb5 4)(piano 0 Bb5 4)(piano 0 G5 4)(piano 0 G5 4)(piano 0 F6 4))",
"(seq (piano 0 F6 4) (piano 0 Eb6 4)(piano 0 Eb6 4)(piano 0 D6 4)(piano 0 Eb6 4)(piano 0 F6 4)(piano 0 Eb6 8)(rest 16)",
"(seq (rest 4)(piano 0 Eb6 4) (piano 0 EB6 4) (piano 0 F6 4) (piano 0 F6 4)(piano 0 G6 4)(piano 0 G6 4)(piano 0 A6 4)(piano 0 A6 4)(piano 0 F6 4)(piano 0 F6 4)(piano 0 C6 4)(piano 0 C6 4)(piano 0 EB6 4))",
"(seq (piano 0 EB6 4)(piano 0 D6 4) (piano 0 D6 4)(piano 0 C6 4)(piano 0 C6 4)(piano 0 EB6 4)(piano 0 D6 8)(piano 0 D7 4)(piano 0 D8 10)(rest 2))",
"(seq (piano 0 D6 8) (piano 0 G5 4) (piano 0 BB5 4) (piano 0 D6 4)(piano 0 C6 4)(piano 0 D6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 D6 4)(piano 0 C6 4)(piano 0 D6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 EB6 4)(piano 0 D6 4)(piano 0 EB6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 EB6 4)(piano 0 D6 4))",
"(seq (piano 0 EB6 8) (piano 0 EB6 4)(piano 0 D6 4)(piano 0 EB6 4)(piano 0 E6 4)(piano 0 F6 8)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 D6 24) )",
"(seq (piano 0 D7 8) (piano 0 G6 4) (piano 0 BB6 4) (piano 0 D7 4)(piano 0 C7 4)(piano 0 D7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 D7 4)(piano 0 C7 4)(piano 0 D7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 EB7 4)(piano 0 D7 4)(piano 0 EB7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 EB7 4)(piano 0 D7 4))",
"(seq (piano 0 EB7 8) (piano 0 EB7 4)(piano 0 D7 4)(piano 0 EB7 4)(piano 0 E7 4)(piano 0 F7 8)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 D7 24) )",
"(seq (piano 0 BB6 12)(piano 0 D6 4)(piano 0 D6 4)(piano 0 EB6 4)(piano 0 EB6 12)(piano 0 C6 4)(piano 0 C6 4)(piano 0 A6 4)(piano 0 A6 12)(piano 0 C6 4)(piano 0 C6 4)(piano 0 D6 4)(piano 0 D6 8)(piano 0 BB5 4)(piano 0 BB5 4)(piano 0 G6 4)(piano 0 F6 4))",
"(seq (piano 0 G6 12)(piano 0 BB5 4)(piano 0 BB5 4)(piano 0 C6 4)(piano 0 C6 12)(piano 0 A5 4)(piano 0 D6 4)(piano 0 C6 4)(piano 0 D6 24))",
"(seq (piano 0 BB6 12)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 12)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 12)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 D6 24))",
"(seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 12)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 12)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 G6 24))", //13
"(sync (seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 8)(rest 4)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 8)(rest 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 D6 16))(seq (piano 0 BB7 8)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 C8 4)(piano 0 C8 8)(rest 4)(piano 0 BB7 4)(piano 0 A7 4)(piano 0 G7 4)(piano 0 F7 8)(rest 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)(piano 0 D7 16)))",
"(rest 8)",
"(sync (seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 8)(rest 4)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 8)(rest 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4))(seq (piano 0 BB7 8)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 C8 4)(piano 0 C8 8)(rest 4)(piano 0 BB7 4)(piano 0 A7 4)(piano 0 G7 4)(piano 0 F7 8)(rest 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)))",
"(sync (piano 1 G6 16) (piano 1 G7 16))",
"(rest 24)",
"(seq (piano 0 D6 8) (piano 0 G5 4) (piano 0 BB5 4) (piano 0 D6 4)(piano 0 C6 4)(piano 0 D6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 D6 4)(piano 0 C6 4)(piano 0 D6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 EB6 4)(piano 0 D6 4)(piano 0 EB6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 EB6 4)(piano 0 D6 4))",
"(seq (piano 0 EB6 8) (piano 0 EB6 4)(piano 0 D6 4)(piano 0 EB6 4)(piano 0 E6 4)(piano 0 F6 8)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 D6 24) )",
"(seq (piano 0 D7 8) (piano 0 G6 4) (piano 0 BB6 4) (piano 0 D7 4)(piano 0 C7 4)(piano 0 D7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 D7 4)(piano 0 C7 4)(piano 0 D7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 EB7 4)(piano 0 D7 4)(piano 0 EB7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 EB7 4)(piano 0 D7 4))",
"(seq (piano 0 EB7 8) (piano 0 EB7 4)(piano 0 D7 4)(piano 0 EB7 4)(piano 0 E7 4)(piano 0 F7 8)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 D7 24) )",
"(seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 12)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 12)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 d6 24))",
"(seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 12)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 12)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 G6 24))",//22
"(sync (seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 8)(rest 4)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 8)(rest 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 D6 16))(seq (piano 0 BB7 8)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 C8 4)(piano 0 C8 8)(rest 4)(piano 0 BB7 4)(piano 0 A7 4)(piano 0 G7 4)(piano 0 F7 8)(rest 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)(piano 0 D7 16)))",
"(rest 8)",
"(sync (seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 8)(rest 4)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 8)(rest 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4))(seq (piano 0 BB7 8)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 C8 4)(piano 0 C8 8)(rest 4)(piano 0 BB7 4)(piano 0 A7 4)(piano 0 G7 4)(piano 0 F7 8)(rest 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)))", //24
"(sync (piano 1 G6 16) (piano 1 G7 16))",
"(seq(rest 24)(piano 2 G6 4)",
"(seq (piano 0 G6 4) (piano 0 A6 4) (piano 0 A6 4)(piano 0 Bb6 4)(piano 0 Bb6 4)(piano 0 A6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 G6 4)(piano 0 D6 4)(piano 0 D6 4)(piano 0 Bb5 4)(piano 0 Bb5 4)(piano 0 G5 4)(piano 0 G5 4)(piano 0 F6 4))",
"(seq (piano 0 F6 4) (piano 0 Eb6 4)(piano 0 Eb6 4)(piano 0 D6 4)(piano 0 Eb6 4)(piano 0 F6 4)(piano 0 Eb6 8)(rest 16)",
"(seq (rest 4)(piano 0 Eb6 4) (piano 0 EB6 4) (piano 0 F6 4) (piano 0 F6 4)(piano 0 G6 4)(piano 0 G6 4)(piano 0 A6 4)(piano 0 A6 4)(piano 0 F6 4)(piano 0 F6 4)(piano 0 C6 4)(piano 0 C6 4)(piano 0 EB6 4))",
"(seq (piano 0 EB6 4)(piano 0 D6 4) (piano 0 D6 4)(piano 0 C6 4)(piano 0 C6 4)(piano 0 EB6 4)(piano 0 D6 8)(piano 0 D7 4)(piano 0 D8 10)(rest 2))",
"(seq (piano 0 D6 8) (piano 0 G5 4) (piano 0 BB5 4) (piano 0 D6 4)(piano 0 C6 4)(piano 0 D6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 D6 4)(piano 0 C6 4)(piano 0 D6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 EB6 4)(piano 0 D6 4)(piano 0 EB6 8)(piano 0 G5 4) (piano 0 BB5 4) (piano 0 EB6 4)(piano 0 D6 4))",
"(seq (piano 0 EB6 8) (piano 0 EB6 4)(piano 0 D6 4)(piano 0 EB6 4)(piano 0 E6 4)(piano 0 F6 8)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 D6 24) )",
"(seq (piano 0 D7 8) (piano 0 G6 4) (piano 0 BB6 4) (piano 0 D7 4)(piano 0 C7 4)(piano 0 D7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 D7 4)(piano 0 C7 4)(piano 0 D7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 EB7 4)(piano 0 D7 4)(piano 0 EB7 8)(piano 0 G6 4) (piano 0 BB6 4) (piano 0 EB7 4)(piano 0 D7 4))",
"(seq (piano 0 EB7 8) (piano 0 EB7 4)(piano 0 D7 4)(piano 0 EB7 4)(piano 0 E7 4)(piano 0 F7 8)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 D7 24) )",
"(seq (piano 0 BB6 12)(piano 0 D6 4)(piano 0 D6 4)(piano 0 EB6 4)(piano 0 EB6 12)(piano 0 C6 4)(piano 0 C6 4)(piano 0 A6 4)(piano 0 A6 12)(piano 0 C6 4)(piano 0 C6 4)(piano 0 D6 4)(piano 0 D6 8)(piano 0 BB5 4)(piano 0 BB5 4)(piano 0 G6 4)(piano 0 F6 4))",
"(seq (piano 0 G6 12)(piano 0 BB5 4)(piano 0 BB5 4)(piano 0 C6 4)(piano 0 C6 12)(piano 0 A5 4)(piano 0 D6 4)(piano 0 C6 4)(piano 0 D6 24))",
"(seq (piano 0 BB6 12)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 12)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 12)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 D6 24))",
"(seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 12)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 12)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 G6 24))", //13
"(sync (seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 8)(rest 4)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 8)(rest 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 D6 16))(seq (piano 0 BB7 8)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 C8 4)(piano 0 C8 8)(rest 4)(piano 0 BB7 4)(piano 0 A7 4)(piano 0 G7 4)(piano 0 F7 8)(rest 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)(piano 0 D7 16)))",
"(rest 8)",
"(sync (seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 8)(rest 4)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 8)(rest 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4))(seq (piano 0 BB7 8)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 C8 4)(piano 0 C8 8)(rest 4)(piano 0 BB7 4)(piano 0 A7 4)(piano 0 G7 4)(piano 0 F7 8)(rest 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)))",
"(sync (piano 1 G6 16) (piano 1 G7 16))",
"(seq (rest 8)(piano 0 BB6 12)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 12)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 12)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 D6 24))",
"(seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 12)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 12)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 G6 24))", //13
"(sync (seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 8)(rest 4)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 8)(rest 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4)(piano 0 D6 16))(seq (piano 0 BB7 8)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 C8 4)(piano 0 C8 8)(rest 4)(piano 0 BB7 4)(piano 0 A7 4)(piano 0 G7 4)(piano 0 F7 8)(rest 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4)(piano 0 D7 16)))",
"(rest 8)",
"(sync (seq (piano 0 BB6 8)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 BB6 4)(piano 0 C7 4)(piano 0 C7 8)(rest 4)(piano 0 BB6 4)(piano 0 A6 4)(piano 0 G6 4)(piano 0 F6 8)(rest 4)(piano 0 F6 4)(piano 0 G6 4)(piano 0 F6 4))(seq (piano 0 BB7 8)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 BB7 4)(piano 0 C8 4)(piano 0 C8 8)(rest 4)(piano 0 BB7 4)(piano 0 A7 4)(piano 0 G7 4)(piano 0 F7 8)(rest 4)(piano 0 F7 4)(piano 0 G7 4)(piano 0 F7 4))(rest 32))",
"(repeat 2 (sync (piano 1 G6 16) (piano 1 G7 16)))",//here

"(rest 16)" ) );
Cons ent4 = readlist( list (
"(seq (piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8) )",
"(seq (piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8) )",
"(seq (piano 1 EB4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8) )",
"(seq (piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 C4 8)(piano 1 A4 8) )",
"(seq (piano 1 BB3 8)(piano 1 F4 8)(piano 1 D5 8)(piano 1 D4 8)(piano 1 GB5 16) )",
"(seq (piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8) )",
"(seq (piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)))",
"(seq (sync (piano 1 BB4 8)(piano 1 G3 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8) )",
"(seq (piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(sync (piano 1 BB5 8)(piano 1 BB4 8))(sync (piano 1 A3 8)(piano 1 A4 8)))",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)) )",
"(seq (piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 A3 8)(piano 1 EB4 8)(piano 1 C5 8)(piano 1 D4 8)(sync (piano 1 E3 8)(piano 1 E4 8))(sync (piano 1 GB3 8)(piano 1 GB4 8)))",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)) )",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8) )", //13
"(seq (piano 1 G4 8)(piano 1 D5 8)(piano 1 BB5 8)(piano 1 C5 8)(piano 1 G5 8)(piano 1 EB6 8)(piano 1 F4 8)(piano 1 C5 8)(piano 1 A5 8)(piano 1 BB4 8)(piano 1 BB5 8)(sync (piano 1 A4 8)(piano 1 A5 8)) )",
"(seq (sync (piano 1 G4 8)(piano 1 G5 8))(piano 1 D5 8)(piano 1 BB5 8)(piano 1 C5 8)(piano 1 G5 8)(piano 1 EB6 8)(piano 1 F4 8)(piano 1 C5 8)(piano 1 A5 8))",
"(seq (piano 1 G4 8)(piano 1 D5 8)(piano 1 BB5 8)(piano 1 D6 8)(piano 1 G6 8)(piano 1 BB6 8))",
"(seq (piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8) )",
"(seq (piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)))",
"(seq (sync (piano 1 BB4 8)(piano 1 G3 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8) )",
"(seq (piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(sync (piano 1 BB5 8)(piano 1 BB4 8))(sync (piano 1 A3 8)(piano 1 A4 8)))",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)) )",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8) )",//22
"(seq (piano 1 G4 8)(piano 1 D5 8)(piano 1 BB5 8)(piano 1 C5 8)(piano 1 G5 8)(piano 1 EB6 8)(piano 1 F4 8)(piano 1 C5 8)(piano 1 A5 8)(piano 1 BB4 8)(piano 1 BB5 8)(sync (piano 1 A4 8)(piano 1 A5 8)) )",
"(seq (sync (piano 1 G4 8)(piano 1 G5 8))(piano 1 D5 8)(piano 1 BB5 8)(piano 1 C5 8)(piano 1 G5 8)(piano 1 EB6 8)(piano 1 F4 8)(piano 1 C5 8)(piano 1 A5 8))", //24
"(seq (piano 1 G4 8)(piano 1 D5 8)(piano 1 BB5 8)(piano 1 D6 8)(piano 1 G6 8)(piano 1 BB6 8))",
"(seq (rest 4)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8) )",
"(seq (piano 1 EB4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8) )",
"(seq (piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 C4 8)(piano 1 A4 8) )",
"(seq (piano 1 BB3 8)(piano 1 F4 8)(piano 1 D5 8)(piano 1 D4 8)(piano 1 GB5 16) )",
"(seq (piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8) )",
"(seq (piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)))",
"(seq (sync (piano 1 BB4 8)(piano 1 G3 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 D4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8) )",
"(seq (piano 1 G4 8)(piano 1 EB5 8)(piano 1 G4 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(sync (piano 1 BB5 8)(piano 1 BB4 8))(sync (piano 1 A3 8)(piano 1 A4 8)))",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)) )",
"(seq (piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8)(piano 1 A3 8)(piano 1 EB4 8)(piano 1 C5 8)(piano 1 D4 8)(sync (piano 1 E3 8)(piano 1 E4 8))(sync (piano 1 GB3 8)(piano 1 GB4 8)))",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)) )",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8) )", //13
"(seq (piano 1 G4 8)(piano 1 D5 8)(piano 1 BB5 8)(piano 1 C5 8)(piano 1 G5 8)(piano 1 EB6 8)(piano 1 F4 8)(piano 1 C5 8)(piano 1 A5 8)(piano 1 BB4 8)(piano 1 BB5 8)(sync (piano 1 A4 8)(piano 1 A5 8)) )",
"(seq (sync (piano 1 G4 8)(piano 1 G5 8))(piano 1 D5 8)(piano 1 BB5 8)(piano 1 C5 8)(piano 1 G5 8)(piano 1 EB6 8)(piano 1 F4 8)(piano 1 C5 8)(piano 1 A5 8))",
"(seq (piano 1 G4 8)(piano 1 D5 8)(piano 1 BB5 8)(piano 1 D6 8))",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 BB3 8)(piano 1 BB4 8)(sync (piano 1 A3 8)(piano 1 A4 8)) )",
"(seq (sync (piano 1 G3 8)(piano 1 G4 8))(piano 1 D4 8)(piano 1 BB4 8)(piano 1 C4 8)(piano 1 G4 8)(piano 1 EB5 8)(piano 1 F3 8)(piano 1 C4 8)(piano 1 A4 8)(piano 1 G3 8)(piano 1 D4 8)(piano 1 BB4 8) )", //13
"(seq (piano 1 G4 8)(piano 1 D5 8)(piano 1 BB5 8)(piano 1 C5 8)(piano 1 G5 8)(piano 1 EB6 8)(piano 1 F4 8)(piano 1 C5 8)(piano 1 A5 8)(piano 1 BB4 8)(piano 1 BB5 8)(sync (piano 1 A4 8)(piano 1 A5 8)) )",
"(seq (sync (piano 1 G4 8)(piano 1 G5 8))(piano 1 D5 8)(piano 1 BB5 8)(piano 1 C5 8)(piano 1 G5 8)(piano 1 EB6 8)(piano 1 F4 8)(piano 1 C5 8)(piano 1 A5 8))",
"(seq (piano 1 G4 8)(piano 1 D5 8)(piano 1 BB5 8)(piano 1 D6 8)(piano 1 G6 8)(piano 1 BB6 8)(piano 1 D7 12)(piano 1 G5 4)(piano 1 BB5 4)(piano 1 D6 4)(piano 1 G6 8))",
"(seq (rest 16))" ) );
System.out.println();
System.out.println(ent3);
System.out.println();
//System.out.println(ent4);
//System.out.println();
Cons entm = list( "sync", cons("seq", ent3), cons("seq", ent4));
System.out.println(entm);
System.out.println();
PriorityQueue pql = initpq(entm);
simulator(pql);
String strl = mstring(240);
System.out.println(strl);
player.play(new Pattern(strl));
