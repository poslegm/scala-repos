package lila.insight

private object EcopeningDB {

  import Ecopening._

  val MAX_MOVES = 25

  lazy val all = allByEco.values.toList.sorted

  lazy val allByFen: Map[FEN, Ecopening] = allByEco.map {
    case (_, opening) => opening.fen -> opening
  }

  lazy val allByEco: Map[ECO, Ecopening] = Map(
    "A00" -> Ecopening(
      "A00",
      "Uncommon Opening",
      "Uncommon Opening",
      "g4, a3, h3, etc.",
      "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",
      ""
    ),
    "A01" -> Ecopening(
      "A01",
      "Nimzovich-Larsen Attack",
      "Nimzovich-Larsen Attack",
      "b3",
      "rnbqkbnr/pppppppp/8/8/8/1P6/P1PPPPPP/RNBQKBNR",
      "b2b3"
    ),
    "A02" -> Ecopening(
      "A02",
      "Bird's Opening",
      "Bird's Opening",
      "f4",
      "rnbqkbnr/pppppppp/8/8/5P2/8/PPPPP1PP/RNBQKBNR",
      "f2f4"
    ),
    "A03" -> Ecopening(
      "A03",
      "Bird's Opening",
      "Bird's Opening",
      "f4 d5",
      "rnbqkbnr/ppp1pppp/8/3p4/5P2/8/PPPPP1PP/RNBQKBNR",
      "d7d5"
    ),
    "A04" -> Ecopening(
      "A04",
      "Reti Opening",
      "Reti Opening",
      "Nf3",
      "rnbqkbnr/pppppppp/8/8/8/5N2/PPPPPPPP/RNBQKB1R",
      "g1f3"
    ),
    "A05" -> Ecopening(
      "A05",
      "Reti Opening",
      "Reti Opening",
      "Nf3 Nf6",
      "rnbqkb1r/pppppppp/5n2/8/8/5N2/PPPPPPPP/RNBQKB1R",
      "g8f6"
    ),
    "A06" -> Ecopening(
      "A06",
      "Reti Opening",
      "Reti Opening",
      "Nf3 d5",
      "rnbqkbnr/ppp1pppp/8/3p4/8/5N2/PPPPPPPP/RNBQKB1R",
      "d7d5"
    ),
    "A07" -> Ecopening(
      "A07",
      "King's Indian Attack",
      "King's Indian Attack",
      "Nf3 d5 g3",
      "rnbqkbnr/ppp1pppp/8/3p4/8/5NP1/PPPPPP1P/RNBQKB1R",
      "g2g3"
    ),
    "A08" -> Ecopening(
      "A08",
      "King's Indian Attack",
      "King's Indian Attack",
      "Nf3 d5 g3 c5 Bg2",
      "rnbqkbnr/pp2pppp/8/2pp4/8/5NP1/PPPPPPBP/RNBQK2R",
      "f1g2"
    ),
    "A09" -> Ecopening(
      "A09",
      "Reti Opening",
      "Reti Opening",
      "Nf3 d5 c4",
      "rnbqkbnr/ppp1pppp/8/3p4/2P5/5N2/PP1PPPPP/RNBQKB1R",
      "c2c4"
    ),
    "A10" -> Ecopening(
      "A10",
      "English",
      "English",
      "c4",
      "rnbqkbnr/pppppppp/8/8/2P5/8/PP1PPPPP/RNBQKBNR",
      "c2c4"
    ),
    "A11" -> Ecopening(
      "A11",
      "English",
      "English, Caro-Kann Defensive System",
      "c4 c6",
      "rnbqkbnr/pp1ppppp/2p5/8/2P5/8/PP1PPPPP/RNBQKBNR",
      "c7c6"
    ),
    "A12" -> Ecopening(
      "A12",
      "English",
      "English with b3",
      "c4 c6 Nf3 d5 b3",
      "rnbqkbnr/pp2pppp/2p5/3p4/2P5/1P3N2/P2PPPPP/RNBQKB1R",
      "b2b3"
    ),
    "A13" -> Ecopening(
      "A13",
      "English",
      "English",
      "c4 e6",
      "rnbqkbnr/pppp1ppp/4p3/8/2P5/8/PP1PPPPP/RNBQKBNR",
      "e7e6"
    ),
    "A14" -> Ecopening(
      "A14",
      "English",
      "English",
      "c4 e6 Nf3 d5 g3 Nf6 Bg2 Be7 O-O",
      "rnbqk2r/ppp1bppp/4pn2/3p4/2P5/5NP1/PP1PPPBP/RNBQ1RK1",
      "e1g1"
    ),
    "A15" -> Ecopening(
      "A15",
      "English",
      "English",
      "c4 Nf6",
      "rnbqkb1r/pppppppp/5n2/8/2P5/8/PP1PPPPP/RNBQKBNR",
      "g8f6"
    ),
    "A16" -> Ecopening(
      "A16",
      "English",
      "English",
      "c4 Nf6 Nc3",
      "rnbqkb1r/pppppppp/5n2/8/2P5/2N5/PP1PPPPP/R1BQKBNR",
      "b1c3"
    ),
    "A17" -> Ecopening(
      "A17",
      "English",
      "English",
      "c4 Nf6 Nc3 e6",
      "rnbqkb1r/pppp1ppp/4pn2/8/2P5/2N5/PP1PPPPP/R1BQKBNR",
      "e7e6"
    ),
    "A18" -> Ecopening(
      "A18",
      "English",
      "English, Mikenas-Carls",
      "c4 Nf6 Nc3 e6 e4",
      "rnbqkb1r/pppp1ppp/4pn2/8/2P1P3/2N5/PP1P1PPP/R1BQKBNR",
      "e2e4"
    ),
    "A19" -> Ecopening(
      "A19",
      "English",
      "English, Mikenas-Carls, Sicilian Variation",
      "c4 Nf6 Nc3 e6 e4 c5",
      "rnbqkb1r/pp1p1ppp/4pn2/2p5/2P1P3/2N5/PP1P1PPP/R1BQKBNR",
      "c7c5"
    ),
    "A20" -> Ecopening(
      "A20",
      "English",
      "English",
      "c4 e5",
      "rnbqkbnr/pppp1ppp/8/4p3/2P5/8/PP1PPPPP/RNBQKBNR",
      "e7e5"
    ),
    "A21" -> Ecopening(
      "A21",
      "English",
      "English",
      "c4 e5 Nc3",
      "rnbqkbnr/pppp1ppp/8/4p3/2P5/2N5/PP1PPPPP/R1BQKBNR",
      "b1c3"
    ),
    "A22" -> Ecopening(
      "A22",
      "English",
      "English",
      "c4 e5 Nc3 Nf6",
      "rnbqkb1r/pppp1ppp/5n2/4p3/2P5/2N5/PP1PPPPP/R1BQKBNR",
      "g8f6"
    ),
    "A23" -> Ecopening(
      "A23",
      "English",
      "English, Bremen System, Keres Variation",
      "c4 e5 Nc3 Nf6 g3 c6",
      "rnbqkb1r/pp1p1ppp/2p2n2/4p3/2P5/2N3P1/PP1PPP1P/R1BQKBNR",
      "c7c6"
    ),
    "A24" -> Ecopening(
      "A24",
      "English",
      "English, Bremen System with ...g6",
      "c4 e5 Nc3 Nf6 g3 g6",
      "rnbqkb1r/pppp1p1p/5np1/4p3/2P5/2N3P1/PP1PPP1P/R1BQKBNR",
      "g7g6"
    ),
    "A25" -> Ecopening(
      "A25",
      "English",
      "English",
      "c4 e5 Nc3 Nc6",
      "r1bqkbnr/pppp1ppp/2n5/4p3/2P5/2N5/PP1PPPPP/R1BQKBNR",
      "b8c6"
    ),
    "A26" -> Ecopening(
      "A26",
      "English",
      "English",
      "c4 e5 Nc3 Nc6 g3 g6 Bg2 Bg7 d3 d6",
      "r1bqk1nr/ppp2pbp/2np2p1/4p3/2P5/2NP2P1/PP2PPBP/R1BQK1NR",
      "d7d6"
    ),
    "A27" -> Ecopening(
      "A27",
      "English",
      "English, Three Knights System",
      "c4 e5 Nc3 Nc6 Nf3",
      "r1bqkbnr/pppp1ppp/2n5/4p3/2P5/2N2N2/PP1PPPPP/R1BQKB1R",
      "g1f3"
    ),
    "A28" -> Ecopening(
      "A28",
      "English",
      "English",
      "c4 e5 Nc3 Nc6 Nf3 Nf6",
      "r1bqkb1r/pppp1ppp/2n2n2/4p3/2P5/2N2N2/PP1PPPPP/R1BQKB1R",
      "g8f6"
    ),
    "A29" -> Ecopening(
      "A29",
      "English",
      "English, Four Knights, Kingside Fianchetto",
      "c4 e5 Nc3 Nc6 Nf3 Nf6 g3",
      "r1bqkb1r/pppp1ppp/2n2n2/4p3/2P5/2N2NP1/PP1PPP1P/R1BQKB1R",
      "g2g3"
    ),
    "A30" -> Ecopening(
      "A30",
      "English",
      "English, Symmetrical",
      "c4 c5",
      "rnbqkbnr/pp1ppppp/8/2p5/2P5/8/PP1PPPPP/RNBQKBNR",
      "c7c5"
    ),
    "A31" -> Ecopening(
      "A31",
      "English",
      "English, Symmetrical, Benoni Formation",
      "c4 c5 Nf3 Nf6 d4",
      "rnbqkb1r/pp1ppppp/5n2/2p5/2PP4/5N2/PP2PPPP/RNBQKB1R",
      "d2d4"
    ),
    "A32" -> Ecopening(
      "A32",
      "English",
      "English, Symmetrical Variation",
      "c4 c5 Nf3 Nf6 d4 cxd4 Nxd4 e6",
      "rnbqkb1r/pp1p1ppp/4pn2/8/2PN4/8/PP2PPPP/RNBQKB1R",
      "e7e6"
    ),
    "A33" -> Ecopening(
      "A33",
      "English",
      "English, Symmetrical",
      "c4 c5 Nf3 Nf6 d4 cxd4 Nxd4 e6 Nc3 Nc6",
      "r1bqkb1r/pp1p1ppp/2n1pn2/8/2PN4/2N5/PP2PPPP/R1BQKB1R",
      "b8c6"
    ),
    "A34" -> Ecopening(
      "A34",
      "English",
      "English, Symmetrical",
      "c4 c5 Nc3",
      "rnbqkbnr/pp1ppppp/8/2p5/2P5/2N5/PP1PPPPP/R1BQKBNR",
      "b1c3"
    ),
    "A35" -> Ecopening(
      "A35",
      "English",
      "English, Symmetrical",
      "c4 c5 Nc3 Nc6",
      "r1bqkbnr/pp1ppppp/2n5/2p5/2P5/2N5/PP1PPPPP/R1BQKBNR",
      "b8c6"
    ),
    "A36" -> Ecopening(
      "A36",
      "English",
      "English",
      "c4 c5 Nc3 Nc6 g3",
      "r1bqkbnr/pp1ppppp/2n5/2p5/2P5/2N3P1/PP1PPP1P/R1BQKBNR",
      "g2g3"
    ),
    "A37" -> Ecopening(
      "A37",
      "English",
      "English, Symmetrical",
      "c4 c5 Nc3 Nc6 g3 g6 Bg2 Bg7 Nf3",
      "r1bqk1nr/pp1pppbp/2n3p1/2p5/2P5/2N2NP1/PP1PPPBP/R1BQK2R",
      "g1f3"
    ),
    "A38" -> Ecopening(
      "A38",
      "English",
      "English, Symmetrical",
      "c4 c5 Nc3 Nc6 g3 g6 Bg2 Bg7 Nf3 Nf6",
      "r1bqk2r/pp1pppbp/2n2np1/2p5/2P5/2N2NP1/PP1PPPBP/R1BQK2R",
      "g8f6"
    ),
    "A39" -> Ecopening(
      "A39",
      "English",
      "English, Symmetrical, Main line with d4",
      "c4 c5 Nc3 Nc6 g3 g6 Bg2 Bg7 Nf3 Nf6 O-O O-O d4",
      "r1bq1rk1/pp1pppbp/2n2np1/2p5/2PP4/2N2NP1/PP2PPBP/R1BQ1RK1",
      "d2d4"
    ),
    "A40" -> Ecopening(
      "A40",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4",
      "rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR",
      "d2d4"
    ),
    "A41" -> Ecopening(
      "A41",
      "Queen's Pawn Game",
      "Queen's Pawn Game (with ...d6)",
      "d4 d6",
      "rnbqkbnr/ppp1pppp/3p4/8/3P4/8/PPP1PPPP/RNBQKBNR",
      "d7d6"
    ),
    "A42" -> Ecopening(
      "A42",
      "Modern Defence",
      "Modern Defence, Averbakh System",
      "d4 d6 c4 g6 Nc3 Bg7 e4",
      "rnbqk1nr/ppp1ppbp/3p2p1/8/2PPP3/2N5/PP3PPP/R1BQKBNR",
      "e2e4"
    ),
    "A43" -> Ecopening(
      "A43",
      "Old Benoni",
      "Old Benoni",
      "d4 c5",
      "rnbqkbnr/pp1ppppp/8/2p5/3P4/8/PPP1PPPP/RNBQKBNR",
      "c7c5"
    ),
    "A44" -> Ecopening(
      "A44",
      "Old Benoni",
      "Old Benoni Defence",
      "d4 c5 d5 e5",
      "rnbqkbnr/pp1p1ppp/8/2pPp3/8/8/PPP1PPPP/RNBQKBNR",
      "e7e5"
    ),
    "A45" -> Ecopening(
      "A45",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 Nf6",
      "rnbqkb1r/pppppppp/5n2/8/3P4/8/PPP1PPPP/RNBQKBNR",
      "g8f6"
    ),
    "A46" -> Ecopening(
      "A46",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 Nf6 Nf3",
      "rnbqkb1r/pppppppp/5n2/8/3P4/5N2/PPP1PPPP/RNBQKB1R",
      "g1f3"
    ),
    "A47" -> Ecopening(
      "A47",
      "Queen's Indian",
      "Queen's Indian",
      "d4 Nf6 Nf3 b6",
      "rnbqkb1r/p1pppppp/1p3n2/8/3P4/5N2/PPP1PPPP/RNBQKB1R",
      "b7b6"
    ),
    "A48" -> Ecopening(
      "A48",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 Nf3 g6",
      "rnbqkb1r/pppppp1p/5np1/8/3P4/5N2/PPP1PPPP/RNBQKB1R",
      "g7g6"
    ),
    "A49" -> Ecopening(
      "A49",
      "King's Indian",
      "King's Indian, Fianchetto without c4",
      "d4 Nf6 Nf3 g6 g3",
      "rnbqkb1r/pppppp1p/5np1/8/3P4/5NP1/PPP1PP1P/RNBQKB1R",
      "g2g3"
    ),
    "A50" -> Ecopening(
      "A50",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 Nf6 c4",
      "rnbqkb1r/pppppppp/5n2/8/2PP4/8/PP2PPPP/RNBQKBNR",
      "c2c4"
    ),
    "A51" -> Ecopening(
      "A51",
      "Budapest Gambit",
      "Budapest Gambit",
      "d4 Nf6 c4 e5",
      "rnbqkb1r/pppp1ppp/5n2/4p3/2PP4/8/PP2PPPP/RNBQKBNR",
      "e7e5"
    ),
    "A52" -> Ecopening(
      "A52",
      "Budapest Gambit",
      "Budapest Gambit",
      "d4 Nf6 c4 e5 dxe5 Ng4",
      "rnbqkb1r/pppp1ppp/8/4P3/2P3n1/8/PP2PPPP/RNBQKBNR",
      "f6g4"
    ),
    "A53" -> Ecopening(
      "A53",
      "Old Indian",
      "Old Indian",
      "d4 Nf6 c4 d6",
      "rnbqkb1r/ppp1pppp/3p1n2/8/2PP4/8/PP2PPPP/RNBQKBNR",
      "d7d6"
    ),
    "A54" -> Ecopening(
      "A54",
      "Old Indian",
      "Old Indian, Ukrainian Variation, 4.Nf3",
      "d4 Nf6 c4 d6 Nc3 e5 Nf3",
      "rnbqkb1r/ppp2ppp/3p1n2/4p3/2PP4/2N2N2/PP2PPPP/R1BQKB1R",
      "g1f3"
    ),
    "A55" -> Ecopening(
      "A55",
      "Old Indian",
      "Old Indian, Main line",
      "d4 Nf6 c4 d6 Nc3 e5 Nf3 Nbd7 e4",
      "r1bqkb1r/pppn1ppp/3p1n2/4p3/2PPP3/2N2N2/PP3PPP/R1BQKB1R",
      "e2e4"
    ),
    "A56" -> Ecopening(
      "A56",
      "Benoni",
      "Benoni Defence",
      "d4 Nf6 c4 c5",
      "rnbqkb1r/pp1ppppp/5n2/2p5/2PP4/8/PP2PPPP/RNBQKBNR",
      "c7c5"
    ),
    "A57" -> Ecopening(
      "A57",
      "Benko Gambit",
      "Benko Gambit",
      "d4 Nf6 c4 c5 d5 b5",
      "rnbqkb1r/p2ppppp/5n2/1ppP4/2P5/8/PP2PPPP/RNBQKBNR",
      "b7b5"
    ),
    "A58" -> Ecopening(
      "A58",
      "Benko Gambit",
      "Benko Gambit",
      "d4 Nf6 c4 c5 d5 b5 cxb5 a6 bxa6",
      "rnbqkb1r/3ppppp/P4n2/2pP4/8/8/PP2PPPP/RNBQKBNR",
      "b5a6"
    ),
    "A59" -> Ecopening(
      "A59",
      "Benko Gambit",
      "Benko Gambit",
      "d4 Nf6 c4 c5 d5 b5 cxb5 a6 bxa6 Bxa6 Nc3 d6 e4",
      "rn1qkb1r/4pppp/b2p1n2/2pP4/4P3/2N5/PP3PPP/R1BQKBNR",
      "e2e4"
    ),
    "A60" -> Ecopening(
      "A60",
      "Benoni",
      "Benoni Defence",
      "d4 Nf6 c4 c5 d5 e6",
      "rnbqkb1r/pp1p1ppp/4pn2/2pP4/2P5/8/PP2PPPP/RNBQKBNR",
      "e7e6"
    ),
    "A61" -> Ecopening(
      "A61",
      "Benoni",
      "Benoni",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 Nf3 g6",
      "rnbqkb1r/pp3p1p/3p1np1/2pP4/8/2N2N2/PP2PPPP/R1BQKB1R",
      "g7g6"
    ),
    "A62" -> Ecopening(
      "A62",
      "Benoni",
      "Benoni, Fianchetto Variation",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 Nf3 g6 g3 Bg7 Bg2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/8/2N2NP1/PP2PPBP/R1BQK2R",
      "e8g8"
    ),
    "A63" -> Ecopening(
      "A63",
      "Benoni",
      "Benoni, Fianchetto, 9...Nbd7",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 Nf3 g6 g3 Bg7 Bg2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/8/2N2NP1/PP2PPBP/R1BQK2R",
      "e8g8"
    ),
    "A64" -> Ecopening(
      "A64",
      "Benoni",
      "Benoni, Fianchetto, 11...Re8",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 Nf3 g6 g3 Bg7 Bg2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/8/2N2NP1/PP2PPBP/R1BQK2R",
      "e8g8"
    ),
    "A65" -> Ecopening(
      "A65",
      "Benoni",
      "Benoni, 6.e4",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4",
      "rnbqkb1r/pp3ppp/3p1n2/2pP4/4P3/2N5/PP3PPP/R1BQKBNR",
      "e2e4"
    ),
    "A66" -> Ecopening(
      "A66",
      "Benoni",
      "Benoni",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 f4",
      "rnbqkb1r/pp3p1p/3p1np1/2pP4/4PP2/2N5/PP4PP/R1BQKBNR",
      "f2f4"
    ),
    "A67" -> Ecopening(
      "A67",
      "Benoni",
      "Benoni, Taimanov Variation",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 f4 Bg7 Bb5+",
      "rnbqk2r/pp3pbp/3p1np1/1BpP4/4PP2/2N5/PP4PP/R1BQK1NR",
      "f1b5"
    ),
    "A68" -> Ecopening(
      "A68",
      "Benoni",
      "Benoni, Four Pawns Attack",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 f4 Bg7 Nf3 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4PP2/2N2N2/PP4PP/R1BQKB1R",
      "e8g8"
    ),
    "A69" -> Ecopening(
      "A69",
      "Benoni",
      "Benoni, Four Pawns Attack, Main line",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 f4 Bg7 Nf3 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4PP2/2N2N2/PP4PP/R1BQKB1R",
      "e8g8"
    ),
    "A70" -> Ecopening(
      "A70",
      "Benoni",
      "Benoni, Classical with 7.Nf3",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3",
      "rnbqkb1r/pp3p1p/3p1np1/2pP4/4P3/2N2N2/PP3PPP/R1BQKB1R",
      "g1f3"
    ),
    "A71" -> Ecopening(
      "A71",
      "Benoni",
      "Benoni, Classical, 8.Bg5",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Bg5",
      "rnbqk2r/pp3pbp/3p1np1/2pP2B1/4P3/2N2N2/PP3PPP/R2QKB1R",
      "c1g5"
    ),
    "A72" -> Ecopening(
      "A72",
      "Benoni",
      "Benoni, Classical without 9.O-O",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Be2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4P3/2N2N2/PP2BPPP/R1BQK2R",
      "e8g8"
    ),
    "A73" -> Ecopening(
      "A73",
      "Benoni",
      "Benoni, Classical, 9.O-O",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Be2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4P3/2N2N2/PP2BPPP/R1BQK2R",
      "e8g8"
    ),
    "A74" -> Ecopening(
      "A74",
      "Benoni",
      "Benoni, Classical, 9...a6, 10.a4",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Be2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4P3/2N2N2/PP2BPPP/R1BQK2R",
      "e8g8"
    ),
    "A75" -> Ecopening(
      "A75",
      "Benoni",
      "Benoni, Classical with ...a6 and 10...Bg4",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Be2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4P3/2N2N2/PP2BPPP/R1BQK2R",
      "e8g8"
    ),
    "A76" -> Ecopening(
      "A76",
      "Benoni",
      "Benoni, Classical, 9...Re8",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Be2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4P3/2N2N2/PP2BPPP/R1BQK2R",
      "e8g8"
    ),
    "A77" -> Ecopening(
      "A77",
      "Benoni",
      "Benoni, Classical, 9...Re8, 10.Nd2",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Be2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4P3/2N2N2/PP2BPPP/R1BQK2R",
      "e8g8"
    ),
    "A78" -> Ecopening(
      "A78",
      "Benoni",
      "Benoni, Classical with ...Re8 and ...Na6",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Be2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4P3/2N2N2/PP2BPPP/R1BQK2R",
      "e8g8"
    ),
    "A79" -> Ecopening(
      "A79",
      "Benoni",
      "Benoni, Classical, 11.f3",
      "d4 Nf6 c4 c5 d5 e6 Nc3 exd5 cxd5 d6 e4 g6 Nf3 Bg7 Be2 O-O",
      "rnbq1rk1/pp3pbp/3p1np1/2pP4/4P3/2N2N2/PP2BPPP/R1BQK2R",
      "e8g8"
    ),
    "A80" -> Ecopening(
      "A80",
      "Dutch",
      "Dutch",
      "d4 f5",
      "rnbqkbnr/ppppp1pp/8/5p2/3P4/8/PPP1PPPP/RNBQKBNR",
      "f7f5"
    ),
    "A81" -> Ecopening(
      "A81",
      "Dutch",
      "Dutch",
      "d4 f5 g3",
      "rnbqkbnr/ppppp1pp/8/5p2/3P4/6P1/PPP1PP1P/RNBQKBNR",
      "g2g3"
    ),
    "A82" -> Ecopening(
      "A82",
      "Dutch",
      "Dutch, Staunton Gambit",
      "d4 f5 e4",
      "rnbqkbnr/ppppp1pp/8/5p2/3PP3/8/PPP2PPP/RNBQKBNR",
      "e2e4"
    ),
    "A83" -> Ecopening(
      "A83",
      "Dutch",
      "Dutch, Staunton Gambit",
      "d4 f5 e4 fxe4 Nc3 Nf6 Bg5",
      "rnbqkb1r/ppppp1pp/5n2/6B1/3Pp3/2N5/PPP2PPP/R2QKBNR",
      "c1g5"
    ),
    "A84" -> Ecopening(
      "A84",
      "Dutch",
      "Dutch",
      "d4 f5 c4",
      "rnbqkbnr/ppppp1pp/8/5p2/2PP4/8/PP2PPPP/RNBQKBNR",
      "c2c4"
    ),
    "A85" -> Ecopening(
      "A85",
      "Dutch",
      "Dutch, with c4 & Nc3",
      "d4 f5 c4 Nf6 Nc3",
      "rnbqkb1r/ppppp1pp/5n2/5p2/2PP4/2N5/PP2PPPP/R1BQKBNR",
      "b1c3"
    ),
    "A86" -> Ecopening(
      "A86",
      "Dutch",
      "Dutch",
      "d4 f5 c4 Nf6 g3",
      "rnbqkb1r/ppppp1pp/5n2/5p2/2PP4/6P1/PP2PP1P/RNBQKBNR",
      "g2g3"
    ),
    "A87" -> Ecopening(
      "A87",
      "Dutch",
      "Dutch, Leningrad, Main Variation",
      "d4 f5 c4 Nf6 g3 g6 Bg2 Bg7 Nf3",
      "rnbqk2r/ppppp1bp/5np1/5p2/2PP4/5NP1/PP2PPBP/RNBQK2R",
      "g1f3"
    ),
    "A88" -> Ecopening(
      "A88",
      "Dutch",
      "Dutch, Leningrad, Main Variation with c6",
      "d4 f5 c4 Nf6 g3 g6 Bg2 Bg7 Nf3 O-O O-O d6 Nc3 c6",
      "rnbq1rk1/pp2p1bp/2pp1np1/5p2/2PP4/2N2NP1/PP2PPBP/R1BQ1RK1",
      "c7c6"
    ),
    "A89" -> Ecopening(
      "A89",
      "Dutch",
      "Dutch, Leningrad, Main Variation with Nc6",
      "d4 f5 c4 Nf6 g3 g6 Bg2 Bg7 Nf3 O-O O-O d6 Nc3 Nc6",
      "r1bq1rk1/ppp1p1bp/2np1np1/5p2/2PP4/2N2NP1/PP2PPBP/R1BQ1RK1",
      "b8c6"
    ),
    "A90" -> Ecopening(
      "A90",
      "Dutch",
      "Dutch",
      "d4 f5 c4 Nf6 g3 e6 Bg2",
      "rnbqkb1r/pppp2pp/4pn2/5p2/2PP4/6P1/PP2PPBP/RNBQK1NR",
      "f1g2"
    ),
    "A91" -> Ecopening(
      "A91",
      "Dutch",
      "Dutch Defence",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7",
      "rnbqk2r/ppppb1pp/4pn2/5p2/2PP4/6P1/PP2PPBP/RNBQK1NR",
      "f8e7"
    ),
    "A92" -> Ecopening(
      "A92",
      "Dutch",
      "Dutch",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7 Nf3 O-O",
      "rnbq1rk1/ppppb1pp/4pn2/5p2/2PP4/5NP1/PP2PPBP/RNBQK2R",
      "e8g8"
    ),
    "A93" -> Ecopening(
      "A93",
      "Dutch",
      "Dutch, Stonewall, Botvinnik Variation",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7 Nf3 O-O O-O d5 b3",
      "rnbq1rk1/ppp1b1pp/4pn2/3p1p2/2PP4/1P3NP1/P3PPBP/RNBQ1RK1",
      "b2b3"
    ),
    "A94" -> Ecopening(
      "A94",
      "Dutch",
      "Dutch, Stonewall with Ba3",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7 Nf3 O-O O-O d5 b3 c6 Ba3",
      "rnbq1rk1/pp2b1pp/2p1pn2/3p1p2/2PP4/BP3NP1/P3PPBP/RN1Q1RK1",
      "c1a3"
    ),
    "A95" -> Ecopening(
      "A95",
      "Dutch",
      "Dutch, Stonewall",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7 Nf3 O-O O-O d5 Nc3 c6",
      "rnbq1rk1/pp2b1pp/2p1pn2/3p1p2/2PP4/2N2NP1/PP2PPBP/R1BQ1RK1",
      "c7c6"
    ),
    "A96" -> Ecopening(
      "A96",
      "Dutch",
      "Dutch, Classical Variation",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7 Nf3 O-O O-O d6",
      "rnbq1rk1/ppp1b1pp/3ppn2/5p2/2PP4/5NP1/PP2PPBP/RNBQ1RK1",
      "d7d6"
    ),
    "A97" -> Ecopening(
      "A97",
      "Dutch",
      "Dutch, Ilyin-Genevsky",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7 Nf3 O-O O-O d6 Nc3 Qe8",
      "rnb1qrk1/ppp1b1pp/3ppn2/5p2/2PP4/2N2NP1/PP2PPBP/R1BQ1RK1",
      "d8e8"
    ),
    "A98" -> Ecopening(
      "A98",
      "Dutch",
      "Dutch, Ilyin-Genevsky Variation with Qc2",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7 Nf3 O-O O-O d6 Nc3 Qe8 Qc2",
      "rnb1qrk1/ppp1b1pp/3ppn2/5p2/2PP4/2N2NP1/PPQ1PPBP/R1B2RK1",
      "d1c2"
    ),
    "A99" -> Ecopening(
      "A99",
      "Dutch",
      "Dutch, Ilyin-Genevsky Variation with b3",
      "d4 f5 c4 Nf6 g3 e6 Bg2 Be7 Nf3 O-O O-O d6 Nc3 Qe8 b3",
      "rnb1qrk1/ppp1b1pp/3ppn2/5p2/2PP4/1PN2NP1/P3PPBP/R1BQ1RK1",
      "b2b3"
    ),
    "B00" -> Ecopening(
      "B00",
      "Uncommon King's Pawn Opening",
      "Uncommon King's Pawn Opening",
      "e4",
      "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR",
      "e2e4"
    ),
    "B01" -> Ecopening(
      "B01",
      "Scandinavian",
      "Scandinavian",
      "e4 d5",
      "rnbqkbnr/ppp1pppp/8/3p4/4P3/8/PPPP1PPP/RNBQKBNR",
      "d7d5"
    ),
    "B02" -> Ecopening(
      "B02",
      "Alekhine's Defence",
      "Alekhine's Defence",
      "e4 Nf6",
      "rnbqkb1r/pppppppp/5n2/8/4P3/8/PPPP1PPP/RNBQKBNR",
      "g8f6"
    ),
    "B03" -> Ecopening(
      "B03",
      "Alekhine's Defence",
      "Alekhine's Defence",
      "e4 Nf6 e5 Nd5 d4",
      "rnbqkb1r/pppppppp/8/3nP3/3P4/8/PPP2PPP/RNBQKBNR",
      "d2d4"
    ),
    "B04" -> Ecopening(
      "B04",
      "Alekhine's Defence",
      "Alekhine's Defence, Modern",
      "e4 Nf6 e5 Nd5 d4 d6 Nf3",
      "rnbqkb1r/ppp1pppp/3p4/3nP3/3P4/5N2/PPP2PPP/RNBQKB1R",
      "g1f3"
    ),
    "B05" -> Ecopening(
      "B05",
      "Alekhine's Defence",
      "Alekhine's Defence, Modern",
      "e4 Nf6 e5 Nd5 d4 d6 Nf3 Bg4",
      "rn1qkb1r/ppp1pppp/3p4/3nP3/3P2b1/5N2/PPP2PPP/RNBQKB1R",
      "c8g4"
    ),
    "B06" -> Ecopening(
      "B06",
      "Robatsch",
      "Robatsch",
      "e4 g6",
      "rnbqkbnr/pppppp1p/6p1/8/4P3/8/PPPP1PPP/RNBQKBNR",
      "g7g6"
    ),
    "B07" -> Ecopening(
      "B07",
      "Pirc",
      "Pirc",
      "e4 d6 d4 Nf6",
      "rnbqkb1r/ppp1pppp/3p1n2/8/3PP3/8/PPP2PPP/RNBQKBNR",
      "g8f6"
    ),
    "B08" -> Ecopening(
      "B08",
      "Pirc",
      "Pirc, Classical",
      "e4 d6 d4 Nf6 Nc3 g6 Nf3",
      "rnbqkb1r/ppp1pp1p/3p1np1/8/3PP3/2N2N2/PPP2PPP/R1BQKB1R",
      "g1f3"
    ),
    "B09" -> Ecopening(
      "B09",
      "Pirc",
      "Pirc, Austrian Attack",
      "e4 d6 d4 Nf6 Nc3 g6 f4",
      "rnbqkb1r/ppp1pp1p/3p1np1/8/3PPP2/2N5/PPP3PP/R1BQKBNR",
      "f2f4"
    ),
    "B10" -> Ecopening(
      "B10",
      "Caro-Kann",
      "Caro-Kann",
      "e4 c6",
      "rnbqkbnr/pp1ppppp/2p5/8/4P3/8/PPPP1PPP/RNBQKBNR",
      "c7c6"
    ),
    "B11" -> Ecopening(
      "B11",
      "Caro-Kann",
      "Caro-Kann, Two Knights, 3...Bg4",
      "e4 c6 Nc3 d5 Nf3 Bg4",
      "rn1qkbnr/pp2pppp/2p5/3p4/4P1b1/2N2N2/PPPP1PPP/R1BQKB1R",
      "c8g4"
    ),
    "B12" -> Ecopening(
      "B12",
      "Caro-Kann",
      "Caro-Kann Defence",
      "e4 c6 d4",
      "rnbqkbnr/pp1ppppp/2p5/8/3PP3/8/PPP2PPP/RNBQKBNR",
      "d2d4"
    ),
    "B13" -> Ecopening(
      "B13",
      "Caro-Kann",
      "Caro-Kann, Exchange",
      "e4 c6 d4 d5 exd5 cxd5",
      "rnbqkbnr/pp2pppp/8/3p4/3P4/8/PPP2PPP/RNBQKBNR",
      "c6d5"
    ),
    "B14" -> Ecopening(
      "B14",
      "Caro-Kann",
      "Caro-Kann, Panov-Botvinnik Attack",
      "e4 c6 d4 d5 exd5 cxd5 c4 Nf6 Nc3 e6",
      "rnbqkb1r/pp3ppp/4pn2/3p4/2PP4/2N5/PP3PPP/R1BQKBNR",
      "e7e6"
    ),
    "B15" -> Ecopening(
      "B15",
      "Caro-Kann",
      "Caro-Kann",
      "e4 c6 d4 d5 Nc3",
      "rnbqkbnr/pp2pppp/2p5/3p4/3PP3/2N5/PPP2PPP/R1BQKBNR",
      "b1c3"
    ),
    "B16" -> Ecopening(
      "B16",
      "Caro-Kann",
      "Caro-Kann, Bronstein-Larsen Variation",
      "e4 c6 d4 d5 Nc3 dxe4 Nxe4 Nf6 Nxf6+ gxf6",
      "rnbqkb1r/pp2pp1p/2p2p2/8/3P4/8/PPP2PPP/R1BQKBNR",
      "g7f6"
    ),
    "B17" -> Ecopening(
      "B17",
      "Caro-Kann",
      "Caro-Kann, Steinitz Variation",
      "e4 c6 d4 d5 Nc3 dxe4 Nxe4 Nd7",
      "r1bqkbnr/pp1npppp/2p5/8/3PN3/8/PPP2PPP/R1BQKBNR",
      "b8d7"
    ),
    "B18" -> Ecopening(
      "B18",
      "Caro-Kann",
      "Caro-Kann, Classical",
      "e4 c6 d4 d5 Nc3 dxe4 Nxe4 Bf5",
      "rn1qkbnr/pp2pppp/2p5/5b2/3PN3/8/PPP2PPP/R1BQKBNR",
      "c8f5"
    ),
    "B19" -> Ecopening(
      "B19",
      "Caro-Kann",
      "Caro-Kann, Classical",
      "e4 c6 d4 d5 Nc3 dxe4 Nxe4 Bf5 Ng3 Bg6 h4 h6 Nf3 Nd7",
      "r2qkbnr/pp1nppp1/2p3bp/8/3P3P/5NN1/PPP2PP1/R1BQKB1R",
      "b8d7"
    ),
    "B20" -> Ecopening(
      "B20",
      "Sicilian",
      "Sicilian",
      "e4 c5",
      "rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR",
      "c7c5"
    ),
    "B21" -> Ecopening(
      "B21",
      "Sicilian",
      "Sicilian, 2.f4 and 2.d4",
      "e4 c5 f4",
      "rnbqkbnr/pp1ppppp/8/2p5/4PP2/8/PPPP2PP/RNBQKBNR",
      "f2f4"
    ),
    "B22" -> Ecopening(
      "B22",
      "Sicilian",
      "Sicilian, Alapin",
      "e4 c5 c3",
      "rnbqkbnr/pp1ppppp/8/2p5/4P3/2P5/PP1P1PPP/RNBQKBNR",
      "c2c3"
    ),
    "B23" -> Ecopening(
      "B23",
      "Sicilian",
      "Sicilian, Closed",
      "e4 c5 Nc3",
      "rnbqkbnr/pp1ppppp/8/2p5/4P3/2N5/PPPP1PPP/R1BQKBNR",
      "b1c3"
    ),
    "B24" -> Ecopening(
      "B24",
      "Sicilian",
      "Sicilian, Closed",
      "e4 c5 Nc3 Nc6 g3",
      "r1bqkbnr/pp1ppppp/2n5/2p5/4P3/2N3P1/PPPP1P1P/R1BQKBNR",
      "g2g3"
    ),
    "B25" -> Ecopening(
      "B25",
      "Sicilian",
      "Sicilian, Closed",
      "e4 c5 Nc3 Nc6 g3 g6 Bg2 Bg7 d3 d6",
      "r1bqk1nr/pp2ppbp/2np2p1/2p5/4P3/2NP2P1/PPP2PBP/R1BQK1NR",
      "d7d6"
    ),
    "B26" -> Ecopening(
      "B26",
      "Sicilian",
      "Sicilian, Closed, 6.Be3",
      "e4 c5 Nc3 Nc6 g3 g6 Bg2 Bg7 d3 d6 Be3",
      "r1bqk1nr/pp2ppbp/2np2p1/2p5/4P3/2NPB1P1/PPP2PBP/R2QK1NR",
      "c1e3"
    ),
    "B27" -> Ecopening(
      "B27",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3",
      "rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "g1f3"
    ),
    "B28" -> Ecopening(
      "B28",
      "Sicilian",
      "Sicilian, O'Kelly Variation",
      "e4 c5 Nf3 a6",
      "rnbqkbnr/1p1ppppp/p7/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "a7a6"
    ),
    "B29" -> Ecopening(
      "B29",
      "Sicilian",
      "Sicilian, Nimzovich-Rubinstein",
      "e4 c5 Nf3 Nf6",
      "rnbqkb1r/pp1ppppp/5n2/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "g8f6"
    ),
    "B30" -> Ecopening(
      "B30",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 Nc6",
      "r1bqkbnr/pp1ppppp/2n5/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "b8c6"
    ),
    "B31" -> Ecopening(
      "B31",
      "Sicilian",
      "Sicilian, Rossolimo Variation",
      "e4 c5 Nf3 Nc6 Bb5 g6",
      "r1bqkbnr/pp1ppp1p/2n3p1/1Bp5/4P3/5N2/PPPP1PPP/RNBQK2R",
      "g7g6"
    ),
    "B32" -> Ecopening(
      "B32",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 e5",
      "r1bqkbnr/pp1p1ppp/2n5/4p3/3NP3/8/PPP2PPP/RNBQKB1R",
      "e7e5"
    ),
    "B33" -> Ecopening(
      "B33",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4",
      "r1bqkbnr/pp1ppppp/2n5/8/3NP3/8/PPP2PPP/RNBQKB1R",
      "f3d4"
    ),
    "B34" -> Ecopening(
      "B34",
      "Sicilian",
      "Sicilian, Accelerated Fianchetto",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 g6 Nxc6",
      "r1bqkbnr/pp1ppp1p/2N3p1/8/4P3/8/PPP2PPP/RNBQKB1R",
      "d4c6"
    ),
    "B35" -> Ecopening(
      "B35",
      "Sicilian",
      "Sicilian, Accelerated Fianchetto, Modern Variation with Bc4",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 g6 Nc3 Bg7 Be3 Nf6 Bc4",
      "r1bqk2r/pp1pppbp/2n2np1/8/2BNP3/2N1B3/PPP2PPP/R2QK2R",
      "f1c4"
    ),
    "B36" -> Ecopening(
      "B36",
      "Sicilian",
      "Sicilian, Accelerated Fianchetto",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 g6 c4",
      "r1bqkbnr/pp1ppp1p/2n3p1/8/2PNP3/8/PP3PPP/RNBQKB1R",
      "c2c4"
    ),
    "B37" -> Ecopening(
      "B37",
      "Sicilian",
      "Sicilian, Accelerated Fianchetto",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 g6 c4 Bg7",
      "r1bqk1nr/pp1pppbp/2n3p1/8/2PNP3/8/PP3PPP/RNBQKB1R",
      "f8g7"
    ),
    "B38" -> Ecopening(
      "B38",
      "Sicilian",
      "Sicilian, Accelerated Fianchetto, Maroczy Bind, 6.Be3",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 g6 c4 Bg7 Be3",
      "r1bqk1nr/pp1pppbp/2n3p1/8/2PNP3/4B3/PP3PPP/RN1QKB1R",
      "c1e3"
    ),
    "B39" -> Ecopening(
      "B39",
      "Sicilian",
      "Sicilian, Accelerated Fianchetto, Breyer Variation",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 g6 c4 Bg7 Be3 Nf6 Nc3 Ng4",
      "r1bqk2r/pp1pppbp/2n3p1/8/2PNP1n1/2N1B3/PP3PPP/R2QKB1R",
      "f6g4"
    ),
    "B40" -> Ecopening(
      "B40",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 e6",
      "rnbqkbnr/pp1p1ppp/4p3/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "e7e6"
    ),
    "B41" -> Ecopening(
      "B41",
      "Sicilian",
      "Sicilian, Kan",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 a6",
      "rnbqkbnr/1p1p1ppp/p3p3/8/3NP3/8/PPP2PPP/RNBQKB1R",
      "a7a6"
    ),
    "B42" -> Ecopening(
      "B42",
      "Sicilian",
      "Sicilian, Kan",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 a6 Bd3",
      "rnbqkbnr/1p1p1ppp/p3p3/8/3NP3/3B4/PPP2PPP/RNBQK2R",
      "f1d3"
    ),
    "B43" -> Ecopening(
      "B43",
      "Sicilian",
      "Sicilian, Kan, 5.Nc3",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 a6 Nc3",
      "rnbqkbnr/1p1p1ppp/p3p3/8/3NP3/2N5/PPP2PPP/R1BQKB1R",
      "b1c3"
    ),
    "B44" -> Ecopening(
      "B44",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 Nc6",
      "r1bqkbnr/pp1p1ppp/2n1p3/8/3NP3/8/PPP2PPP/RNBQKB1R",
      "b8c6"
    ),
    "B45" -> Ecopening(
      "B45",
      "Sicilian",
      "Sicilian, Taimanov",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 Nc6 Nc3",
      "r1bqkbnr/pp1p1ppp/2n1p3/8/3NP3/2N5/PPP2PPP/R1BQKB1R",
      "b1c3"
    ),
    "B46" -> Ecopening(
      "B46",
      "Sicilian",
      "Sicilian, Taimanov Variation",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 Nc6 Nc3 a6",
      "r1bqkbnr/1p1p1ppp/p1n1p3/8/3NP3/2N5/PPP2PPP/R1BQKB1R",
      "a7a6"
    ),
    "B47" -> Ecopening(
      "B47",
      "Sicilian",
      "Sicilian, Taimanov (Bastrikov) Variation",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 Nc6 Nc3 Qc7",
      "r1b1kbnr/ppqp1ppp/2n1p3/8/3NP3/2N5/PPP2PPP/R1BQKB1R",
      "d8c7"
    ),
    "B48" -> Ecopening(
      "B48",
      "Sicilian",
      "Sicilian, Taimanov Variation",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 Nc6 Nc3 Qc7 Be3",
      "r1b1kbnr/ppqp1ppp/2n1p3/8/3NP3/2N1B3/PPP2PPP/R2QKB1R",
      "c1e3"
    ),
    "B49" -> Ecopening(
      "B49",
      "Sicilian",
      "Sicilian, Taimanov Variation",
      "e4 c5 Nf3 e6 d4 cxd4 Nxd4 Nc6 Nc3 Qc7 Be3 a6 Be2",
      "r1b1kbnr/1pqp1ppp/p1n1p3/8/3NP3/2N1B3/PPP1BPPP/R2QK2R",
      "f1e2"
    ),
    "B50" -> Ecopening(
      "B50",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 d6",
      "rnbqkbnr/pp2pppp/3p4/2p5/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "d7d6"
    ),
    "B51" -> Ecopening(
      "B51",
      "Sicilian",
      "Sicilian, Canal-Sokolsky (Rossolimo) Attack",
      "e4 c5 Nf3 d6 Bb5+",
      "rnbqkbnr/pp2pppp/3p4/1Bp5/4P3/5N2/PPPP1PPP/RNBQK2R",
      "f1b5"
    ),
    "B52" -> Ecopening(
      "B52",
      "Sicilian",
      "Sicilian, Canal-Sokolsky (Rossolimo) Attack",
      "e4 c5 Nf3 d6 Bb5+ Bd7",
      "rn1qkbnr/pp1bpppp/3p4/1Bp5/4P3/5N2/PPPP1PPP/RNBQK2R",
      "c8d7"
    ),
    "B53" -> Ecopening(
      "B53",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 d6 d4 cxd4 Qxd4",
      "rnbqkbnr/pp2pppp/3p4/8/3QP3/5N2/PPP2PPP/RNB1KB1R",
      "d1d4"
    ),
    "B54" -> Ecopening(
      "B54",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4",
      "rnbqkbnr/pp2pppp/3p4/8/3NP3/8/PPP2PPP/RNBQKB1R",
      "f3d4"
    ),
    "B55" -> Ecopening(
      "B55",
      "Sicilian",
      "Sicilian, Prins Variation, Venice Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 f3 e5 Bb5+",
      "rnbqkb1r/pp3ppp/3p1n2/1B2p3/3NP3/5P2/PPP3PP/RNBQK2R",
      "f1b5"
    ),
    "B56" -> Ecopening(
      "B56",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3",
      "rnbqkb1r/pp2pppp/3p1n2/8/3NP3/2N5/PPP2PPP/R1BQKB1R",
      "b1c3"
    ),
    "B57" -> Ecopening(
      "B57",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bc4",
      "r1bqkb1r/pp2pppp/2np1n2/8/2BNP3/2N5/PPP2PPP/R1BQK2R",
      "f1c4"
    ),
    "B58" -> Ecopening(
      "B58",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 Nf6 Nc3 d6 Be2",
      "r1bqkb1r/pp2pppp/2np1n2/8/3NP3/2N5/PPP1BPPP/R1BQK2R",
      "f1e2"
    ),
    "B59" -> Ecopening(
      "B59",
      "Sicilian",
      "Sicilian, Boleslavsky Variation, 7.Nb3",
      "e4 c5 Nf3 Nc6 d4 cxd4 Nxd4 Nf6 Nc3 d6 Be2 e5 Nb3",
      "r1bqkb1r/pp3ppp/2np1n2/4p3/4P3/1NN5/PPP1BPPP/R1BQK2R",
      "d4b3"
    ),
    "B60" -> Ecopening(
      "B60",
      "Sicilian",
      "Sicilian, Richter-Rauzer",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5",
      "r1bqkb1r/pp2pppp/2np1n2/6B1/3NP3/2N5/PPP2PPP/R2QKB1R",
      "c1g5"
    ),
    "B61" -> Ecopening(
      "B61",
      "Sicilian",
      "Sicilian, Richter-Rauzer, Larsen Variation, 7.Qd2",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 Bd7 Qd2",
      "r2qkb1r/pp1bpppp/2np1n2/6B1/3NP3/2N5/PPPQ1PPP/R3KB1R",
      "d1d2"
    ),
    "B62" -> Ecopening(
      "B62",
      "Sicilian",
      "Sicilian, Richter-Rauzer",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 e6",
      "r1bqkb1r/pp3ppp/2nppn2/6B1/3NP3/2N5/PPP2PPP/R2QKB1R",
      "e7e6"
    ),
    "B63" -> Ecopening(
      "B63",
      "Sicilian",
      "Sicilian, Richter-Rauzer Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 e6 Qd2",
      "r1bqkb1r/pp3ppp/2nppn2/6B1/3NP3/2N5/PPPQ1PPP/R3KB1R",
      "d1d2"
    ),
    "B64" -> Ecopening(
      "B64",
      "Sicilian",
      "Sicilian, Richter-Rauzer Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 e6 Qd2 Be7 O-O-O O-O f4",
      "r1bq1rk1/pp2bppp/2nppn2/6B1/3NPP2/2N5/PPPQ2PP/2KR1B1R",
      "f2f4"
    ),
    "B65" -> Ecopening(
      "B65",
      "Sicilian",
      "Sicilian, Richter-Rauzer Attack, 7...Be7 Defence, 9...Nxd4",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 e6 Qd2 Be7 O-O-O O-O f4 Nxd4 Qxd4",
      "r1bq1rk1/pp2bppp/3ppn2/6B1/3QPP2/2N5/PPP3PP/2KR1B1R",
      "d2d4"
    ),
    "B66" -> Ecopening(
      "B66",
      "Sicilian",
      "Sicilian, Richter-Rauzer Attack, 7...a6",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 e6 Qd2 a6",
      "r1bqkb1r/1p3ppp/p1nppn2/6B1/3NP3/2N5/PPPQ1PPP/R3KB1R",
      "a7a6"
    ),
    "B67" -> Ecopening(
      "B67",
      "Sicilian",
      "Sicilian, Richter-Rauzer Attack, 7...a6 Defence, 8...Bd7",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 e6 Qd2 a6 O-O-O Bd7",
      "r2qkb1r/1p1b1ppp/p1nppn2/6B1/3NP3/2N5/PPPQ1PPP/2KR1B1R",
      "c8d7"
    ),
    "B68" -> Ecopening(
      "B68",
      "Sicilian",
      "Sicilian, Richter-Rauzer Attack, 7...a6 Defence, 9...Be7",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 e6 Qd2 a6 O-O-O Bd7 f4 Be7",
      "r2qk2r/1p1bbppp/p1nppn2/6B1/3NPP2/2N5/PPPQ2PP/2KR1B1R",
      "f8e7"
    ),
    "B69" -> Ecopening(
      "B69",
      "Sicilian",
      "Sicilian, Richter-Rauzer Attack, 7...a6 Defence, 11.Bxf6",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 Nc6 Bg5 e6 Qd2 a6 O-O-O Bd7 f4 Be7 Nf3 b5 Bxf6",
      "r2qk2r/3bbppp/p1nppB2/1p6/4PP2/2N2N2/PPPQ2PP/2KR1B1R",
      "g5f6"
    ),
    "B70" -> Ecopening(
      "B70",
      "Sicilian",
      "Sicilian, Dragon Variation",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6",
      "rnbqkb1r/pp2pp1p/3p1np1/8/3NP3/2N5/PPP2PPP/R1BQKB1R",
      "g7g6"
    ),
    "B71" -> Ecopening(
      "B71",
      "Sicilian",
      "Sicilian, Dragon, Levenfish Variation",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 f4",
      "rnbqkb1r/pp2pp1p/3p1np1/8/3NPP2/2N5/PPP3PP/R1BQKB1R",
      "f2f4"
    ),
    "B72" -> Ecopening(
      "B72",
      "Sicilian",
      "Sicilian, Dragon",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 Be3",
      "rnbqkb1r/pp2pp1p/3p1np1/8/3NP3/2N1B3/PPP2PPP/R2QKB1R",
      "c1e3"
    ),
    "B73" -> Ecopening(
      "B73",
      "Sicilian",
      "Sicilian, Dragon, Classical",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 Be3 Bg7 Be2 Nc6 O-O",
      "r1bqk2r/pp2ppbp/2np1np1/8/3NP3/2N1B3/PPP1BPPP/R2Q1RK1",
      "e1g1"
    ),
    "B74" -> Ecopening(
      "B74",
      "Sicilian",
      "Sicilian, Dragon, Classical",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 Be3 Bg7 Be2 Nc6 O-O O-O Nb3",
      "r1bq1rk1/pp2ppbp/2np1np1/8/4P3/1NN1B3/PPP1BPPP/R2Q1RK1",
      "d4b3"
    ),
    "B75" -> Ecopening(
      "B75",
      "Sicilian",
      "Sicilian, Dragon, Yugoslav Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 Be3 Bg7 f3",
      "rnbqk2r/pp2ppbp/3p1np1/8/3NP3/2N1BP2/PPP3PP/R2QKB1R",
      "f2f3"
    ),
    "B76" -> Ecopening(
      "B76",
      "Sicilian",
      "Sicilian, Dragon, Yugoslav Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 Be3 Bg7 f3 O-O",
      "rnbq1rk1/pp2ppbp/3p1np1/8/3NP3/2N1BP2/PPP3PP/R2QKB1R",
      "e8g8"
    ),
    "B77" -> Ecopening(
      "B77",
      "Sicilian",
      "Sicilian, Dragon, Yugoslav Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 Be3 Bg7 f3 O-O Qd2 Nc6 Bc4",
      "r1bq1rk1/pp2ppbp/2np1np1/8/2BNP3/2N1BP2/PPPQ2PP/R3K2R",
      "f1c4"
    ),
    "B78" -> Ecopening(
      "B78",
      "Sicilian",
      "Sicilian, Dragon, Yugoslav Attack, 10.castle long",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 Be3 Bg7 f3 O-O Qd2 Nc6 Bc4 Bd7 O-O-O",
      "r2q1rk1/pp1bppbp/2np1np1/8/2BNP3/2N1BP2/PPPQ2PP/2KR3R",
      "e1c1"
    ),
    "B79" -> Ecopening(
      "B79",
      "Sicilian",
      "Sicilian, Dragon, Yugoslav Attack, 12.h4",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 g6 Be3 Bg7 f3 O-O Qd2 Nc6 Bc4 Bd7 O-O-O Qa5 Bb3 Rfc8 h4",
      "r1r3k1/pp1bppbp/2np1np1/q7/3NP2P/1BN1BP2/PPPQ2P1/2KR3R",
      "h2h4"
    ),
    "B80" -> Ecopening(
      "B80",
      "Sicilian",
      "Sicilian, Scheveningen",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6",
      "rnbqkb1r/pp3ppp/3ppn2/8/3NP3/2N5/PPP2PPP/R1BQKB1R",
      "e7e6"
    ),
    "B81" -> Ecopening(
      "B81",
      "Sicilian",
      "Sicilian, Scheveningen, Keres Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 g4",
      "rnbqkb1r/pp3ppp/3ppn2/8/3NP1P1/2N5/PPP2P1P/R1BQKB1R",
      "g2g4"
    ),
    "B82" -> Ecopening(
      "B82",
      "Sicilian",
      "Sicilian, Scheveningen",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 f4",
      "rnbqkb1r/pp3ppp/3ppn2/8/3NPP2/2N5/PPP3PP/R1BQKB1R",
      "f2f4"
    ),
    "B83" -> Ecopening(
      "B83",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 Be2",
      "rnbqkb1r/pp3ppp/3ppn2/8/3NP3/2N5/PPP1BPPP/R1BQK2R",
      "f1e2"
    ),
    "B84" -> Ecopening(
      "B84",
      "Sicilian",
      "Sicilian, Scheveningen",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 Be2 a6",
      "rnbqkb1r/1p3ppp/p2ppn2/8/3NP3/2N5/PPP1BPPP/R1BQK2R",
      "a7a6"
    ),
    "B85" -> Ecopening(
      "B85",
      "Sicilian",
      "Sicilian, Scheveningen, Classical",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 Be2 a6 O-O Qc7 f4 Nc6",
      "r1b1kb1r/1pq2ppp/p1nppn2/8/3NPP2/2N5/PPP1B1PP/R1BQ1RK1",
      "b8c6"
    ),
    "B86" -> Ecopening(
      "B86",
      "Sicilian",
      "Sicilian, Fischer-Sozin Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 Bc4",
      "rnbqkb1r/pp3ppp/3ppn2/8/2BNP3/2N5/PPP2PPP/R1BQK2R",
      "f1c4"
    ),
    "B87" -> Ecopening(
      "B87",
      "Sicilian",
      "Sicilian, Fischer-Sozin with ...a6 and ...b5",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 Bc4 a6 Bb3 b5",
      "rnbqkb1r/5ppp/p2ppn2/1p6/3NP3/1BN5/PPP2PPP/R1BQK2R",
      "b7b5"
    ),
    "B88" -> Ecopening(
      "B88",
      "Sicilian",
      "Sicilian, Fischer-Sozin Attack",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 Bc4 Nc6",
      "r1bqkb1r/pp3ppp/2nppn2/8/2BNP3/2N5/PPP2PPP/R1BQK2R",
      "b8c6"
    ),
    "B89" -> Ecopening(
      "B89",
      "Sicilian",
      "Sicilian",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 e6 Bc4 Nc6 Be3",
      "r1bqkb1r/pp3ppp/2nppn2/8/2BNP3/2N1B3/PPP2PPP/R2QK2R",
      "c1e3"
    ),
    "B90" -> Ecopening(
      "B90",
      "Sicilian",
      "Sicilian, Najdorf",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6",
      "rnbqkb1r/1p2pppp/p2p1n2/8/3NP3/2N5/PPP2PPP/R1BQKB1R",
      "a7a6"
    ),
    "B91" -> Ecopening(
      "B91",
      "Sicilian",
      "Sicilian, Najdorf, Zagreb (Fianchetto) Variation",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 g3",
      "rnbqkb1r/1p2pppp/p2p1n2/8/3NP3/2N3P1/PPP2P1P/R1BQKB1R",
      "g2g3"
    ),
    "B92" -> Ecopening(
      "B92",
      "Sicilian",
      "Sicilian, Najdorf, Opocensky Variation",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 Be2",
      "rnbqkb1r/1p2pppp/p2p1n2/8/3NP3/2N5/PPP1BPPP/R1BQK2R",
      "f1e2"
    ),
    "B93" -> Ecopening(
      "B93",
      "Sicilian",
      "Sicilian, Najdorf, 6.f4",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 f4",
      "rnbqkb1r/1p2pppp/p2p1n2/8/3NPP2/2N5/PPP3PP/R1BQKB1R",
      "f2f4"
    ),
    "B94" -> Ecopening(
      "B94",
      "Sicilian",
      "Sicilian, Najdorf",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 Bg5",
      "rnbqkb1r/1p2pppp/p2p1n2/6B1/3NP3/2N5/PPP2PPP/R2QKB1R",
      "c1g5"
    ),
    "B95" -> Ecopening(
      "B95",
      "Sicilian",
      "Sicilian, Najdorf, 6...e6",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 Bg5 e6",
      "rnbqkb1r/1p3ppp/p2ppn2/6B1/3NP3/2N5/PPP2PPP/R2QKB1R",
      "e7e6"
    ),
    "B96" -> Ecopening(
      "B96",
      "Sicilian",
      "Sicilian, Najdorf",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 Bg5 e6 f4",
      "rnbqkb1r/1p3ppp/p2ppn2/6B1/3NPP2/2N5/PPP3PP/R2QKB1R",
      "f2f4"
    ),
    "B97" -> Ecopening(
      "B97",
      "Sicilian",
      "Sicilian, Najdorf",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 Bg5 e6 f4 Qb6",
      "rnb1kb1r/1p3ppp/pq1ppn2/6B1/3NPP2/2N5/PPP3PP/R2QKB1R",
      "d8b6"
    ),
    "B98" -> Ecopening(
      "B98",
      "Sicilian",
      "Sicilian, Najdorf",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 Bg5 e6 f4 Be7",
      "rnbqk2r/1p2bppp/p2ppn2/6B1/3NPP2/2N5/PPP3PP/R2QKB1R",
      "f8e7"
    ),
    "B99" -> Ecopening(
      "B99",
      "Sicilian",
      "Sicilian, Najdorf, 7...Be7 Main line",
      "e4 c5 Nf3 d6 d4 cxd4 Nxd4 Nf6 Nc3 a6 Bg5 e6 f4 Be7 Qf3 Qc7 O-O-O Nbd7",
      "r1b1k2r/1pqnbppp/p2ppn2/6B1/3NPP2/2N2Q2/PPP3PP/2KR1B1R",
      "b8d7"
    ),
    "C00" -> Ecopening(
      "C00",
      "French",
      "French Defence",
      "e4 e6",
      "rnbqkbnr/pppp1ppp/4p3/8/4P3/8/PPPP1PPP/RNBQKBNR",
      "e7e6"
    ),
    "C01" -> Ecopening(
      "C01",
      "French",
      "French, Exchange",
      "e4 e6 d4 d5 exd5 exd5 Nc3 Nf6 Bg5",
      "rnbqkb1r/ppp2ppp/5n2/3p2B1/3P4/2N5/PPP2PPP/R2QKBNR",
      "c1g5"
    ),
    "C02" -> Ecopening(
      "C02",
      "French",
      "French, Advance",
      "e4 e6 d4 d5 e5",
      "rnbqkbnr/ppp2ppp/4p3/3pP3/3P4/8/PPP2PPP/RNBQKBNR",
      "e4e5"
    ),
    "C03" -> Ecopening(
      "C03",
      "French",
      "French, Tarrasch",
      "e4 e6 d4 d5 Nd2",
      "rnbqkbnr/ppp2ppp/4p3/3p4/3PP3/8/PPPN1PPP/R1BQKBNR",
      "b1d2"
    ),
    "C04" -> Ecopening(
      "C04",
      "French",
      "French, Tarrasch, Guimard Main line",
      "e4 e6 d4 d5 Nd2 Nc6 Ngf3 Nf6",
      "r1bqkb1r/ppp2ppp/2n1pn2/3p4/3PP3/5N2/PPPN1PPP/R1BQKB1R",
      "g8f6"
    ),
    "C05" -> Ecopening(
      "C05",
      "French",
      "French, Tarrasch",
      "e4 e6 d4 d5 Nd2 Nf6",
      "rnbqkb1r/ppp2ppp/4pn2/3p4/3PP3/8/PPPN1PPP/R1BQKBNR",
      "g8f6"
    ),
    "C06" -> Ecopening(
      "C06",
      "French",
      "French, Tarrasch",
      "e4 e6 d4 d5 Nd2 Nf6 e5 Nfd7 Bd3 c5 c3 Nc6 Ne2 cxd4 cxd4",
      "r1bqkb1r/pp1n1ppp/2n1p3/3pP3/3P4/3B4/PP1NNPPP/R1BQK2R",
      "c3d4"
    ),
    "C07" -> Ecopening(
      "C07",
      "French",
      "French, Tarrasch",
      "e4 e6 d4 d5 Nd2 c5",
      "rnbqkbnr/pp3ppp/4p3/2pp4/3PP3/8/PPPN1PPP/R1BQKBNR",
      "c7c5"
    ),
    "C08" -> Ecopening(
      "C08",
      "French",
      "French, Tarrasch, Open, 4.ed ed",
      "e4 e6 d4 d5 Nd2 c5 exd5 exd5",
      "rnbqkbnr/pp3ppp/8/2pp4/3P4/8/PPPN1PPP/R1BQKBNR",
      "e6d5"
    ),
    "C09" -> Ecopening(
      "C09",
      "French",
      "French, Tarrasch, Open Variation, Main line",
      "e4 e6 d4 d5 Nd2 c5 exd5 exd5 Ngf3 Nc6",
      "r1bqkbnr/pp3ppp/2n5/2pp4/3P4/5N2/PPPN1PPP/R1BQKB1R",
      "b8c6"
    ),
    "C10" -> Ecopening(
      "C10",
      "French",
      "French",
      "e4 e6 d4 d5 Nc3",
      "rnbqkbnr/ppp2ppp/4p3/3p4/3PP3/2N5/PPP2PPP/R1BQKBNR",
      "b1c3"
    ),
    "C11" -> Ecopening(
      "C11",
      "French",
      "French",
      "e4 e6 d4 d5 Nc3 Nf6",
      "rnbqkb1r/ppp2ppp/4pn2/3p4/3PP3/2N5/PPP2PPP/R1BQKBNR",
      "g8f6"
    ),
    "C12" -> Ecopening(
      "C12",
      "French",
      "French, McCutcheon",
      "e4 e6 d4 d5 Nc3 Nf6 Bg5 Bb4",
      "rnbqk2r/ppp2ppp/4pn2/3p2B1/1b1PP3/2N5/PPP2PPP/R2QKBNR",
      "f8b4"
    ),
    "C13" -> Ecopening(
      "C13",
      "French",
      "French",
      "e4 e6 d4 d5 Nc3 Nf6 Bg5 Be7",
      "rnbqk2r/ppp1bppp/4pn2/3p2B1/3PP3/2N5/PPP2PPP/R2QKBNR",
      "f8e7"
    ),
    "C14" -> Ecopening(
      "C14",
      "French",
      "French, Classical",
      "e4 e6 d4 d5 Nc3 Nf6 Bg5 Be7 e5 Nfd7 Bxe7 Qxe7",
      "rnb1k2r/pppnqppp/4p3/3pP3/3P4/2N5/PPP2PPP/R2QKBNR",
      "d8e7"
    ),
    "C15" -> Ecopening(
      "C15",
      "French",
      "French, Winawer",
      "e4 e6 d4 d5 Nc3 Bb4",
      "rnbqk1nr/ppp2ppp/4p3/3p4/1b1PP3/2N5/PPP2PPP/R1BQKBNR",
      "f8b4"
    ),
    "C16" -> Ecopening(
      "C16",
      "French",
      "French, Winawer",
      "e4 e6 d4 d5 Nc3 Bb4 e5",
      "rnbqk1nr/ppp2ppp/4p3/3pP3/1b1P4/2N5/PPP2PPP/R1BQKBNR",
      "e4e5"
    ),
    "C17" -> Ecopening(
      "C17",
      "French",
      "French, Winawer, Advance",
      "e4 e6 d4 d5 Nc3 Bb4 e5 c5",
      "rnbqk1nr/pp3ppp/4p3/2ppP3/1b1P4/2N5/PPP2PPP/R1BQKBNR",
      "c7c5"
    ),
    "C18" -> Ecopening(
      "C18",
      "French",
      "French, Winawer",
      "e4 e6 d4 d5 Nc3 Bb4 e5 c5 a3 Bxc3+ bxc3",
      "rnbqk1nr/pp3ppp/4p3/2ppP3/3P4/P1P5/2P2PPP/R1BQKBNR",
      "b2c3"
    ),
    "C19" -> Ecopening(
      "C19",
      "French",
      "French, Winawer, Advance",
      "e4 e6 d4 d5 Nc3 Bb4 e5 c5 a3 Bxc3+ bxc3 Ne7",
      "rnbqk2r/pp2nppp/4p3/2ppP3/3P4/P1P5/2P2PPP/R1BQKBNR",
      "g8e7"
    ),
    "C20" -> Ecopening(
      "C20",
      "King's Pawn Game",
      "King's Pawn Game",
      "e4 e5",
      "rnbqkbnr/pppp1ppp/8/4p3/4P3/8/PPPP1PPP/RNBQKBNR",
      "e7e5"
    ),
    "C21" -> Ecopening(
      "C21",
      "Center Game",
      "Center Game",
      "e4 e5 d4 exd4",
      "rnbqkbnr/pppp1ppp/8/8/3pP3/8/PPP2PPP/RNBQKBNR",
      "e5d4"
    ),
    "C22" -> Ecopening(
      "C22",
      "Center Game",
      "Center Game",
      "e4 e5 d4 exd4 Qxd4 Nc6",
      "r1bqkbnr/pppp1ppp/2n5/8/3QP3/8/PPP2PPP/RNB1KBNR",
      "b8c6"
    ),
    "C23" -> Ecopening(
      "C23",
      "Bishop's Opening",
      "Bishop's Opening",
      "e4 e5 Bc4",
      "rnbqkbnr/pppp1ppp/8/4p3/2B1P3/8/PPPP1PPP/RNBQK1NR",
      "f1c4"
    ),
    "C24" -> Ecopening(
      "C24",
      "Bishop's Opening",
      "Bishop's Opening",
      "e4 e5 Bc4 Nf6",
      "rnbqkb1r/pppp1ppp/5n2/4p3/2B1P3/8/PPPP1PPP/RNBQK1NR",
      "g8f6"
    ),
    "C25" -> Ecopening(
      "C25",
      "Vienna",
      "Vienna",
      "e4 e5 Nc3",
      "rnbqkbnr/pppp1ppp/8/4p3/4P3/2N5/PPPP1PPP/R1BQKBNR",
      "b1c3"
    ),
    "C26" -> Ecopening(
      "C26",
      "Vienna",
      "Vienna",
      "e4 e5 Nc3 Nf6",
      "rnbqkb1r/pppp1ppp/5n2/4p3/4P3/2N5/PPPP1PPP/R1BQKBNR",
      "g8f6"
    ),
    "C27" -> Ecopening(
      "C27",
      "Vienna Game",
      "Vienna Game",
      "e4 e5 Nc3 Nf6 Bc4 Nxe4",
      "rnbqkb1r/pppp1ppp/8/4p3/2B1n3/2N5/PPPP1PPP/R1BQK1NR",
      "f6e4"
    ),
    "C28" -> Ecopening(
      "C28",
      "Vienna Game",
      "Vienna Game",
      "e4 e5 Nc3 Nf6 Bc4 Nc6",
      "r1bqkb1r/pppp1ppp/2n2n2/4p3/2B1P3/2N5/PPPP1PPP/R1BQK1NR",
      "b8c6"
    ),
    "C29" -> Ecopening(
      "C29",
      "Vienna Gambit",
      "Vienna Gambit",
      "e4 e5 Nc3 Nf6 f4",
      "rnbqkb1r/pppp1ppp/5n2/4p3/4PP2/2N5/PPPP2PP/R1BQKBNR",
      "f2f4"
    ),
    "C30" -> Ecopening(
      "C30",
      "King's Gambit Declined",
      "King's Gambit Declined",
      "e4 e5 f4",
      "rnbqkbnr/pppp1ppp/8/4p3/4PP2/8/PPPP2PP/RNBQKBNR",
      "f2f4"
    ),
    "C31" -> Ecopening(
      "C31",
      "King's Gambit Declined",
      "King's Gambit Declined, Falkbeer Counter Gambit",
      "e4 e5 f4 d5",
      "rnbqkbnr/ppp2ppp/8/3pp3/4PP2/8/PPPP2PP/RNBQKBNR",
      "d7d5"
    ),
    "C32" -> Ecopening(
      "C32",
      "King's Gambit Declined",
      "King's Gambit Declined, Falkbeer Counter Gambit",
      "e4 e5 f4 d5 exd5 e4 d3 Nf6",
      "rnbqkb1r/ppp2ppp/5n2/3P4/4pP2/3P4/PPP3PP/RNBQKBNR",
      "g8f6"
    ),
    "C33" -> Ecopening(
      "C33",
      "King's Gambit Accepted",
      "King's Gambit Accepted",
      "e4 e5 f4 exf4",
      "rnbqkbnr/pppp1ppp/8/8/4Pp2/8/PPPP2PP/RNBQKBNR",
      "e5f4"
    ),
    "C34" -> Ecopening(
      "C34",
      "King's Gambit Accepted",
      "King's Gambit Accepted",
      "e4 e5 f4 exf4 Nf3",
      "rnbqkbnr/pppp1ppp/8/8/4Pp2/5N2/PPPP2PP/RNBQKB1R",
      "g1f3"
    ),
    "C35" -> Ecopening(
      "C35",
      "King's Gambit Accepted",
      "King's Gambit Accepted, Cunningham",
      "e4 e5 f4 exf4 Nf3 Be7",
      "rnbqk1nr/ppppbppp/8/8/4Pp2/5N2/PPPP2PP/RNBQKB1R",
      "f8e7"
    ),
    "C36" -> Ecopening(
      "C36",
      "King's Gambit Accepted",
      "King's Gambit Accepted, Abbazia Defence",
      "e4 e5 f4 exf4 Nf3 d5",
      "rnbqkbnr/ppp2ppp/8/3p4/4Pp2/5N2/PPPP2PP/RNBQKB1R",
      "d7d5"
    ),
    "C37" -> Ecopening(
      "C37",
      "King's Gambit Accepted",
      "King's Gambit Accepted",
      "e4 e5 f4 exf4 Nf3 g5 Nc3",
      "rnbqkbnr/pppp1p1p/8/6p1/4Pp2/2N2N2/PPPP2PP/R1BQKB1R",
      "b1c3"
    ),
    "C38" -> Ecopening(
      "C38",
      "King's Gambit Accepted",
      "King's Gambit Accepted",
      "e4 e5 f4 exf4 Nf3 g5 Bc4 Bg7",
      "rnbqk1nr/pppp1pbp/8/6p1/2B1Pp2/5N2/PPPP2PP/RNBQK2R",
      "f8g7"
    ),
    "C39" -> Ecopening(
      "C39",
      "King's Gambit Accepted",
      "King's Gambit Accepted",
      "e4 e5 f4 exf4 Nf3 g5 h4",
      "rnbqkbnr/pppp1p1p/8/6p1/4Pp1P/5N2/PPPP2P1/RNBQKB1R",
      "h2h4"
    ),
    "C40" -> Ecopening(
      "C40",
      "King's Knight Opening",
      "King's Knight Opening",
      "e4 e5 Nf3",
      "rnbqkbnr/pppp1ppp/8/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "g1f3"
    ),
    "C41" -> Ecopening(
      "C41",
      "Philidor Defence",
      "Philidor Defence",
      "e4 e5 Nf3 d6",
      "rnbqkbnr/ppp2ppp/3p4/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "d7d6"
    ),
    "C42" -> Ecopening(
      "C42",
      "Petrov Defence",
      "Petrov Defence",
      "e4 e5 Nf3 Nf6",
      "rnbqkb1r/pppp1ppp/5n2/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "g8f6"
    ),
    "C43" -> Ecopening(
      "C43",
      "Petrov",
      "Petrov, Modern Attack",
      "e4 e5 Nf3 Nf6 d4 exd4 e5 Ne4 Qxd4",
      "rnbqkb1r/pppp1ppp/8/4P3/3Qn3/5N2/PPP2PPP/RNB1KB1R",
      "d1d4"
    ),
    "C44" -> Ecopening(
      "C44",
      "King's Pawn Game",
      "King's Pawn Game",
      "e4 e5 Nf3 Nc6",
      "r1bqkbnr/pppp1ppp/2n5/4p3/4P3/5N2/PPPP1PPP/RNBQKB1R",
      "b8c6"
    ),
    "C45" -> Ecopening(
      "C45",
      "Scotch Game",
      "Scotch Game",
      "e4 e5 Nf3 Nc6 d4 exd4 Nxd4",
      "r1bqkbnr/pppp1ppp/2n5/8/3NP3/8/PPP2PPP/RNBQKB1R",
      "f3d4"
    ),
    "C46" -> Ecopening(
      "C46",
      "Three Knights",
      "Three Knights",
      "e4 e5 Nf3 Nc6 Nc3",
      "r1bqkbnr/pppp1ppp/2n5/4p3/4P3/2N2N2/PPPP1PPP/R1BQKB1R",
      "b1c3"
    ),
    "C47" -> Ecopening(
      "C47",
      "Four Knights",
      "Four Knights",
      "e4 e5 Nf3 Nc6 Nc3 Nf6",
      "r1bqkb1r/pppp1ppp/2n2n2/4p3/4P3/2N2N2/PPPP1PPP/R1BQKB1R",
      "g8f6"
    ),
    "C48" -> Ecopening(
      "C48",
      "Four Knights",
      "Four Knights",
      "e4 e5 Nf3 Nc6 Nc3 Nf6 Bb5",
      "r1bqkb1r/pppp1ppp/2n2n2/1B2p3/4P3/2N2N2/PPPP1PPP/R1BQK2R",
      "f1b5"
    ),
    "C49" -> Ecopening(
      "C49",
      "Four Knights",
      "Four Knights",
      "e4 e5 Nf3 Nc6 Nc3 Nf6 Bb5 Bb4",
      "r1bqk2r/pppp1ppp/2n2n2/1B2p3/1b2P3/2N2N2/PPPP1PPP/R1BQK2R",
      "f8b4"
    ),
    "C50" -> Ecopening(
      "C50",
      "Giuoco Piano",
      "Giuoco Piano",
      "e4 e5 Nf3 Nc6 Bc4 Bc5",
      "r1bqk1nr/pppp1ppp/2n5/2b1p3/2B1P3/5N2/PPPP1PPP/RNBQK2R",
      "f8c5"
    ),
    "C51" -> Ecopening(
      "C51",
      "Evans Gambit",
      "Evans Gambit",
      "e4 e5 Nf3 Nc6 Bc4 Bc5 b4",
      "r1bqk1nr/pppp1ppp/2n5/2b1p3/1PB1P3/5N2/P1PP1PPP/RNBQK2R",
      "b2b4"
    ),
    "C52" -> Ecopening(
      "C52",
      "Evans Gambit",
      "Evans Gambit",
      "e4 e5 Nf3 Nc6 Bc4 Bc5 b4 Bxb4 c3 Ba5",
      "r1bqk1nr/pppp1ppp/2n5/b3p3/2B1P3/2P2N2/P2P1PPP/RNBQK2R",
      "b4a5"
    ),
    "C53" -> Ecopening(
      "C53",
      "Giuoco Piano",
      "Giuoco Piano",
      "e4 e5 Nf3 Nc6 Bc4 Bc5 c3",
      "r1bqk1nr/pppp1ppp/2n5/2b1p3/2B1P3/2P2N2/PP1P1PPP/RNBQK2R",
      "c2c3"
    ),
    "C54" -> Ecopening(
      "C54",
      "Giuoco Piano",
      "Giuoco Piano",
      "e4 e5 Nf3 Nc6 Bc4 Bc5 c3 Nf6 d4 exd4 cxd4",
      "r1bqk2r/pppp1ppp/2n2n2/2b5/2BPP3/5N2/PP3PPP/RNBQK2R",
      "c3d4"
    ),
    "C55" -> Ecopening(
      "C55",
      "Two Knights",
      "Two Knights Defence",
      "e4 e5 Nf3 Nc6 Bc4 Nf6",
      "r1bqkb1r/pppp1ppp/2n2n2/4p3/2B1P3/5N2/PPPP1PPP/RNBQK2R",
      "g8f6"
    ),
    "C56" -> Ecopening(
      "C56",
      "Two Knights",
      "Two Knights",
      "e4 e5 Nf3 Nc6 Bc4 Nf6 d4 exd4 O-O Nxe4",
      "r1bqkb1r/pppp1ppp/2n5/8/2Bpn3/5N2/PPP2PPP/RNBQ1RK1",
      "f6e4"
    ),
    "C57" -> Ecopening(
      "C57",
      "Two Knights",
      "Two Knights",
      "e4 e5 Nf3 Nc6 Bc4 Nf6 Ng5",
      "r1bqkb1r/pppp1ppp/2n2n2/4p1N1/2B1P3/8/PPPP1PPP/RNBQK2R",
      "f3g5"
    ),
    "C58" -> Ecopening(
      "C58",
      "Two Knights",
      "Two Knights",
      "e4 e5 Nf3 Nc6 Bc4 Nf6 Ng5 d5 exd5 Na5",
      "r1bqkb1r/ppp2ppp/5n2/n2Pp1N1/2B5/8/PPPP1PPP/RNBQK2R",
      "c6a5"
    ),
    "C59" -> Ecopening(
      "C59",
      "Two Knights",
      "Two Knights",
      "e4 e5 Nf3 Nc6 Bc4 Nf6 Ng5 d5 exd5 Na5 Bb5+ c6 dxc6 bxc6 Be2 h6",
      "r1bqkb1r/p4pp1/2p2n1p/n3p1N1/8/8/PPPPBPPP/RNBQK2R",
      "h7h6"
    ),
    "C60" -> Ecopening(
      "C60",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5",
      "r1bqkbnr/pppp1ppp/2n5/1B2p3/4P3/5N2/PPPP1PPP/RNBQK2R",
      "f1b5"
    ),
    "C61" -> Ecopening(
      "C61",
      "Ruy Lopez",
      "Ruy Lopez, Bird's Defence",
      "e4 e5 Nf3 Nc6 Bb5 Nd4",
      "r1bqkbnr/pppp1ppp/8/1B2p3/3nP3/5N2/PPPP1PPP/RNBQK2R",
      "c6d4"
    ),
    "C62" -> Ecopening(
      "C62",
      "Ruy Lopez",
      "Ruy Lopez, Old Steinitz Defence",
      "e4 e5 Nf3 Nc6 Bb5 d6",
      "r1bqkbnr/ppp2ppp/2np4/1B2p3/4P3/5N2/PPPP1PPP/RNBQK2R",
      "d7d6"
    ),
    "C63" -> Ecopening(
      "C63",
      "Ruy Lopez",
      "Ruy Lopez, Schliemann Defence",
      "e4 e5 Nf3 Nc6 Bb5 f5",
      "r1bqkbnr/pppp2pp/2n5/1B2pp2/4P3/5N2/PPPP1PPP/RNBQK2R",
      "f7f5"
    ),
    "C64" -> Ecopening(
      "C64",
      "Ruy Lopez",
      "Ruy Lopez, Classical",
      "e4 e5 Nf3 Nc6 Bb5 Bc5",
      "r1bqk1nr/pppp1ppp/2n5/1Bb1p3/4P3/5N2/PPPP1PPP/RNBQK2R",
      "f8c5"
    ),
    "C65" -> Ecopening(
      "C65",
      "Ruy Lopez",
      "Ruy Lopez, Berlin Defence",
      "e4 e5 Nf3 Nc6 Bb5 Nf6",
      "r1bqkb1r/pppp1ppp/2n2n2/1B2p3/4P3/5N2/PPPP1PPP/RNBQK2R",
      "g8f6"
    ),
    "C66" -> Ecopening(
      "C66",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5 Nf6 O-O d6",
      "r1bqkb1r/ppp2ppp/2np1n2/1B2p3/4P3/5N2/PPPP1PPP/RNBQ1RK1",
      "d7d6"
    ),
    "C67" -> Ecopening(
      "C67",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5 Nf6 O-O Nxe4",
      "r1bqkb1r/pppp1ppp/2n5/1B2p3/4n3/5N2/PPPP1PPP/RNBQ1RK1",
      "f6e4"
    ),
    "C68" -> Ecopening(
      "C68",
      "Ruy Lopez",
      "Ruy Lopez, Exchange",
      "e4 e5 Nf3 Nc6 Bb5 a6 Bxc6",
      "r1bqkbnr/1ppp1ppp/p1B5/4p3/4P3/5N2/PPPP1PPP/RNBQK2R",
      "b5c6"
    ),
    "C69" -> Ecopening(
      "C69",
      "Ruy Lopez",
      "Ruy Lopez, Exchange, Gligoric Variation, 6.d4",
      "e4 e5 Nf3 Nc6 Bb5 a6 Bxc6 dc O-O f6 d4",
      "r1bqkbnr/1ppp2pp/p1B2p2/4p3/3PP3/5N2/PPP2PPP/RNBQK2R",
      "d2d4"
    ),
    "C70" -> Ecopening(
      "C70",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4",
      "r1bqkbnr/1ppp1ppp/p1n5/4p3/B3P3/5N2/PPPP1PPP/RNBQK2R",
      "b5a4"
    ),
    "C71" -> Ecopening(
      "C71",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 d6",
      "r1bqkbnr/1pp2ppp/p1np4/4p3/B3P3/5N2/PPPP1PPP/RNBQK2R",
      "d7d6"
    ),
    "C72" -> Ecopening(
      "C72",
      "Ruy Lopez",
      "Ruy Lopez, Modern Steinitz Defence, 5.O-O",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 d6 O-O",
      "r1bqkbnr/1pp2ppp/p1np4/4p3/B3P3/5N2/PPPP1PPP/RNBQ1RK1",
      "e1g1"
    ),
    "C73" -> Ecopening(
      "C73",
      "Ruy Lopez",
      "Ruy Lopez, Modern Steinitz Defence",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 d6 Bxc6+ bxc6 d4",
      "r1bqkbnr/2p2ppp/p1pp4/4p3/3PP3/5N2/PPP2PPP/RNBQK2R",
      "d2d4"
    ),
    "C74" -> Ecopening(
      "C74",
      "Ruy Lopez",
      "Ruy Lopez, Modern Steinitz Defence",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 d6 c3",
      "r1bqkbnr/1pp2ppp/p1np4/4p3/B3P3/2P2N2/PP1P1PPP/RNBQK2R",
      "c2c3"
    ),
    "C75" -> Ecopening(
      "C75",
      "Ruy Lopez",
      "Ruy Lopez, Modern Steinitz Defence",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 d6 c3 Bd7",
      "r2qkbnr/1ppb1ppp/p1np4/4p3/B3P3/2P2N2/PP1P1PPP/RNBQK2R",
      "c8d7"
    ),
    "C76" -> Ecopening(
      "C76",
      "Ruy Lopez",
      "Ruy Lopez, Modern Steinitz Defence, Fianchetto Variation",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 d6 c3 Bd7 d4 g6",
      "r2qkbnr/1ppb1p1p/p1np2p1/4p3/B2PP3/2P2N2/PP3PPP/RNBQK2R",
      "g7g6"
    ),
    "C77" -> Ecopening(
      "C77",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6",
      "r1bqkb1r/1ppp1ppp/p1n2n2/4p3/B3P3/5N2/PPPP1PPP/RNBQK2R",
      "g8f6"
    ),
    "C78" -> Ecopening(
      "C78",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O",
      "r1bqkb1r/1ppp1ppp/p1n2n2/4p3/B3P3/5N2/PPPP1PPP/RNBQ1RK1",
      "e1g1"
    ),
    "C79" -> Ecopening(
      "C79",
      "Ruy Lopez",
      "Ruy Lopez, Steinitz Defence Deferred",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O d6",
      "r1bqkb1r/1pp2ppp/p1np1n2/4p3/B3P3/5N2/PPPP1PPP/RNBQ1RK1",
      "d7d6"
    ),
    "C80" -> Ecopening(
      "C80",
      "Ruy Lopez",
      "Ruy Lopez, Open",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Nxe4",
      "r1bqkb1r/1ppp1ppp/p1n5/4p3/B3n3/5N2/PPPP1PPP/RNBQ1RK1",
      "f6e4"
    ),
    "C81" -> Ecopening(
      "C81",
      "Ruy Lopez",
      "Ruy Lopez, Open, Howell Attack",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Nxe4 d4 b5 Bb3 d5 dxe5 Be6",
      "r2qkb1r/2p2ppp/p1n1b3/1p1pP3/4n3/1B3N2/PPP2PPP/RNBQ1RK1",
      "c8e6"
    ),
    "C82" -> Ecopening(
      "C82",
      "Ruy Lopez",
      "Ruy Lopez, Open",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Nxe4 d4 b5 Bb3 d5 dxe5 Be6 c3",
      "r2qkb1r/2p2ppp/p1n1b3/1p1pP3/4n3/1BP2N2/PP3PPP/RNBQ1RK1",
      "c2c3"
    ),
    "C83" -> Ecopening(
      "C83",
      "Ruy Lopez",
      "Ruy Lopez, Open",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Nxe4 d4 b5 Bb3 d5 dxe5 Be6",
      "r2qkb1r/2p2ppp/p1n1b3/1p1pP3/4n3/1B3N2/PPP2PPP/RNBQ1RK1",
      "c8e6"
    ),
    "C84" -> Ecopening(
      "C84",
      "Ruy Lopez",
      "Ruy Lopez, Closed",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7",
      "r1bqk2r/1pppbppp/p1n2n2/4p3/B3P3/5N2/PPPP1PPP/RNBQ1RK1",
      "f8e7"
    ),
    "C85" -> Ecopening(
      "C85",
      "Ruy Lopez",
      "Ruy Lopez, Exchange Variation Doubly Deferred (DERLD)",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Bxc6 dxc6",
      "r1bqk2r/1pp1bppp/p1p2n2/4p3/4P3/5N2/PPPP1PPP/RNBQ1RK1",
      "d7c6"
    ),
    "C86" -> Ecopening(
      "C86",
      "Ruy Lopez",
      "Ruy Lopez, Worrall Attack",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Qe2",
      "r1bqk2r/1pppbppp/p1n2n2/4p3/B3P3/5N2/PPPPQPPP/RNB2RK1",
      "d1e2"
    ),
    "C87" -> Ecopening(
      "C87",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 d6",
      "r1bqk2r/1pp1bppp/p1np1n2/4p3/B3P3/5N2/PPPP1PPP/RNBQR1K1",
      "d7d6"
    ),
    "C88" -> Ecopening(
      "C88",
      "Ruy Lopez",
      "Ruy Lopez",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3",
      "r1bqk2r/2ppbppp/p1n2n2/1p2p3/4P3/1B3N2/PPPP1PPP/RNBQR1K1",
      "a4b3"
    ),
    "C89" -> Ecopening(
      "C89",
      "Ruy Lopez",
      "Ruy Lopez, Marshall",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d5",
      "r1bq1rk1/2p1bppp/p1n2n2/1p1pp3/4P3/1BP2N2/PP1P1PPP/RNBQR1K1",
      "d7d5"
    ),
    "C90" -> Ecopening(
      "C90",
      "Ruy Lopez",
      "Ruy Lopez, Closed",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6",
      "r1bq1rk1/2p1bppp/p1np1n2/1p2p3/4P3/1BP2N2/PP1P1PPP/RNBQR1K1",
      "d7d6"
    ),
    "C91" -> Ecopening(
      "C91",
      "Ruy Lopez",
      "Ruy Lopez, Closed",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 d4",
      "r1bq1rk1/2p1bppp/p1np1n2/1p2p3/3PP3/1BP2N2/PP3PPP/RNBQR1K1",
      "d2d4"
    ),
    "C92" -> Ecopening(
      "C92",
      "Ruy Lopez",
      "Ruy Lopez, Closed",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 h3",
      "r1bq1rk1/2p1bppp/p1np1n2/1p2p3/4P3/1BP2N1P/PP1P1PP1/RNBQR1K1",
      "h2h3"
    ),
    "C93" -> Ecopening(
      "C93",
      "Ruy Lopez",
      "Ruy Lopez, Closed, Smyslov Defence",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 h3 h6",
      "r1bq1rk1/2p1bpp1/p1np1n1p/1p2p3/4P3/1BP2N1P/PP1P1PP1/RNBQR1K1",
      "h7h6"
    ),
    "C94" -> Ecopening(
      "C94",
      "Ruy Lopez",
      "Ruy Lopez, Closed, Breyer Defence",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 h3 Nb8",
      "rnbq1rk1/2p1bppp/p2p1n2/1p2p3/4P3/1BP2N1P/PP1P1PP1/RNBQR1K1",
      "c6b8"
    ),
    "C95" -> Ecopening(
      "C95",
      "Ruy Lopez",
      "Ruy Lopez, Closed, Breyer",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 h3 Nb8 d4",
      "rnbq1rk1/2p1bppp/p2p1n2/1p2p3/3PP3/1BP2N1P/PP3PP1/RNBQR1K1",
      "d2d4"
    ),
    "C96" -> Ecopening(
      "C96",
      "Ruy Lopez",
      "Ruy Lopez, Closed",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 h3 Na5 Bc2",
      "r1bq1rk1/2p1bppp/p2p1n2/np2p3/4P3/2P2N1P/PPBP1PP1/RNBQR1K1",
      "b3c2"
    ),
    "C97" -> Ecopening(
      "C97",
      "Ruy Lopez",
      "Ruy Lopez, Closed, Chigorin",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 h3 Na5 Bc2 c5 d4 Qc7",
      "r1b2rk1/2q1bppp/p2p1n2/npp1p3/3PP3/2P2N1P/PPB2PP1/RNBQR1K1",
      "d8c7"
    ),
    "C98" -> Ecopening(
      "C98",
      "Ruy Lopez",
      "Ruy Lopez, Closed, Chigorin",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 h3 Na5 Bc2 c5 d4 Qc7 Nbd2 Nc6",
      "r1b2rk1/2q1bppp/p1np1n2/1pp1p3/3PP3/2P2N1P/PPBN1PP1/R1BQR1K1",
      "a5c6"
    ),
    "C99" -> Ecopening(
      "C99",
      "Ruy Lopez",
      "Ruy Lopez, Closed, Chigorin, 12...cd",
      "e4 e5 Nf3 Nc6 Bb5 a6 Ba4 Nf6 O-O Be7 Re1 b5 Bb3 O-O c3 d6 h3 Na5 Bc2 c5 d4 Qc7 Nbd2 cxd4 cxd4",
      "r1b2rk1/2q1bppp/p2p1n2/np2p3/3PP3/5N1P/PPBN1PP1/R1BQR1K1",
      "c3d4"
    ),
    "D00" -> Ecopening(
      "D00",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 d5",
      "rnbqkbnr/ppp1pppp/8/3p4/3P4/8/PPP1PPPP/RNBQKBNR",
      "d7d5"
    ),
    "D01" -> Ecopening(
      "D01",
      "Richter-Veresov Attack",
      "Richter-Veresov Attack",
      "d4 d5 Nc3 Nf6 Bg5",
      "rnbqkb1r/ppp1pppp/5n2/3p2B1/3P4/2N5/PPP1PPPP/R2QKBNR",
      "c1g5"
    ),
    "D02" -> Ecopening(
      "D02",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 d5 Nf3",
      "rnbqkbnr/ppp1pppp/8/3p4/3P4/5N2/PPP1PPPP/RNBQKB1R",
      "g1f3"
    ),
    "D03" -> Ecopening(
      "D03",
      "Torre Attack",
      "Torre Attack (Tartakower Variation)",
      "d4 d5 Nf3 Nf6 Bg5",
      "rnbqkb1r/ppp1pppp/5n2/3p2B1/3P4/5N2/PPP1PPPP/RN1QKB1R",
      "c1g5"
    ),
    "D04" -> Ecopening(
      "D04",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 d5 Nf3 Nf6 e3",
      "rnbqkb1r/ppp1pppp/5n2/3p4/3P4/4PN2/PPP2PPP/RNBQKB1R",
      "e2e3"
    ),
    "D05" -> Ecopening(
      "D05",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 d5 Nf3 Nf6 e3 e6",
      "rnbqkb1r/ppp2ppp/4pn2/3p4/3P4/4PN2/PPP2PPP/RNBQKB1R",
      "e7e6"
    ),
    "D06" -> Ecopening(
      "D06",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4",
      "rnbqkbnr/ppp1pppp/8/3p4/2PP4/8/PP2PPPP/RNBQKBNR",
      "c2c4"
    ),
    "D07" -> Ecopening(
      "D07",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Chigorin Defence",
      "d4 d5 c4 Nc6",
      "r1bqkbnr/ppp1pppp/2n5/3p4/2PP4/8/PP2PPPP/RNBQKBNR",
      "b8c6"
    ),
    "D08" -> Ecopening(
      "D08",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Albin Counter Gambit",
      "d4 d5 c4 e5",
      "rnbqkbnr/ppp2ppp/8/3pp3/2PP4/8/PP2PPPP/RNBQKBNR",
      "e7e5"
    ),
    "D09" -> Ecopening(
      "D09",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Albin Counter Gambit, 5.g3",
      "d4 d5 c4 e5 dxe5 d4 Nf3 Nc6 g3",
      "r1bqkbnr/ppp2ppp/2n5/4P3/2Pp4/5NP1/PP2PP1P/RNBQKB1R",
      "g2g3"
    ),
    "D10" -> Ecopening(
      "D10",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav",
      "d4 d5 c4 c6",
      "rnbqkbnr/pp2pppp/2p5/3p4/2PP4/8/PP2PPPP/RNBQKBNR",
      "c7c6"
    ),
    "D11" -> Ecopening(
      "D11",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav",
      "d4 d5 c4 c6 Nf3",
      "rnbqkbnr/pp2pppp/2p5/3p4/2PP4/5N2/PP2PPPP/RNBQKB1R",
      "g1f3"
    ),
    "D12" -> Ecopening(
      "D12",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav",
      "d4 d5 c4 c6 Nf3 Nf6 e3 Bf5",
      "rn1qkb1r/pp2pppp/2p2n2/3p1b2/2PP4/4PN2/PP3PPP/RNBQKB1R",
      "c8f5"
    ),
    "D13" -> Ecopening(
      "D13",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav, Exchange Variation",
      "d4 d5 c4 c6 Nf3 Nf6 cxd5 cxd5",
      "rnbqkb1r/pp2pppp/5n2/3p4/3P4/5N2/PP2PPPP/RNBQKB1R",
      "c6d5"
    ),
    "D14" -> Ecopening(
      "D14",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav, Exchange Variation",
      "d4 d5 c4 c6 Nf3 Nf6 cxd5 cxd5 Nc3 Nc6 Bf4 Bf5",
      "r2qkb1r/pp2pppp/2n2n2/3p1b2/3P1B2/2N2N2/PP2PPPP/R2QKB1R",
      "c8f5"
    ),
    "D15" -> Ecopening(
      "D15",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav",
      "d4 d5 c4 c6 Nf3 Nf6 Nc3",
      "rnbqkb1r/pp2pppp/2p2n2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R",
      "b1c3"
    ),
    "D16" -> Ecopening(
      "D16",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav",
      "d4 d5 c4 c6 Nf3 Nf6 Nc3 dxc4 a4",
      "rnbqkb1r/pp2pppp/2p2n2/8/P1pP4/2N2N2/1P2PPPP/R1BQKB1R",
      "a2a4"
    ),
    "D17" -> Ecopening(
      "D17",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav",
      "d4 d5 c4 c6 Nf3 Nf6 Nc3 dxc4 a4 Bf5",
      "rn1qkb1r/pp2pppp/2p2n2/5b2/P1pP4/2N2N2/1P2PPPP/R1BQKB1R",
      "c8f5"
    ),
    "D18" -> Ecopening(
      "D18",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav, Dutch",
      "d4 d5 c4 c6 Nf3 Nf6 Nc3 dxc4 a4 Bf5 e3",
      "rn1qkb1r/pp2pppp/2p2n2/5b2/P1pP4/2N1PN2/1P3PPP/R1BQKB1R",
      "e2e3"
    ),
    "D19" -> Ecopening(
      "D19",
      "Queen's Gambit Declined Slav",
      "Queen's Gambit Declined Slav, Dutch",
      "d4 d5 c4 c6 Nf3 Nf6 Nc3 dxc4 a4 Bf5 e3 e6 Bxc4 Bb4 O-O O-O Qe2",
      "rn1q1rk1/pp3ppp/2p1pn2/5b2/PbBP4/2N1PN2/1P2QPPP/R1B2RK1",
      "d1e2"
    ),
    "D20" -> Ecopening(
      "D20",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted",
      "d4 d5 c4 dxc4",
      "rnbqkbnr/ppp1pppp/8/8/2pP4/8/PP2PPPP/RNBQKBNR",
      "d5c4"
    ),
    "D21" -> Ecopening(
      "D21",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted",
      "d4 d5 c4 dxc4 Nf3",
      "rnbqkbnr/ppp1pppp/8/8/2pP4/5N2/PP2PPPP/RNBQKB1R",
      "g1f3"
    ),
    "D22" -> Ecopening(
      "D22",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted",
      "d4 d5 c4 dxc4 Nf3 a6 e3 Bg4 Bxc4 e6 d5",
      "rn1qkbnr/1pp2ppp/p3p3/3P4/2B3b1/4PN2/PP3PPP/RNBQK2R",
      "d4d5"
    ),
    "D23" -> Ecopening(
      "D23",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted",
      "d4 d5 c4 dxc4 Nf3 Nf6",
      "rnbqkb1r/ppp1pppp/5n2/8/2pP4/5N2/PP2PPPP/RNBQKB1R",
      "g8f6"
    ),
    "D24" -> Ecopening(
      "D24",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted",
      "d4 d5 c4 dxc4 Nf3 Nf6 Nc3",
      "rnbqkb1r/ppp1pppp/5n2/8/2pP4/2N2N2/PP2PPPP/R1BQKB1R",
      "b1c3"
    ),
    "D25" -> Ecopening(
      "D25",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted",
      "d4 d5 c4 dxc4 Nf3 Nf6 e3",
      "rnbqkb1r/ppp1pppp/5n2/8/2pP4/4PN2/PP3PPP/RNBQKB1R",
      "e2e3"
    ),
    "D26" -> Ecopening(
      "D26",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted",
      "d4 d5 c4 dxc4 Nf3 Nf6 e3 e6",
      "rnbqkb1r/ppp2ppp/4pn2/8/2pP4/4PN2/PP3PPP/RNBQKB1R",
      "e7e6"
    ),
    "D27" -> Ecopening(
      "D27",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted, Classical",
      "d4 d5 c4 dxc4 Nf3 Nf6 e3 e6 Bxc4 c5 O-O a6",
      "rnbqkb1r/1p3ppp/p3pn2/2p5/2BP4/4PN2/PP3PPP/RNBQ1RK1",
      "a7a6"
    ),
    "D28" -> Ecopening(
      "D28",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted, Classical",
      "d4 d5 c4 dxc4 Nf3 Nf6 e3 e6 Bxc4 c5 O-O a6 Qe2",
      "rnbqkb1r/1p3ppp/p3pn2/2p5/2BP4/4PN2/PP2QPPP/RNB2RK1",
      "d1e2"
    ),
    "D29" -> Ecopening(
      "D29",
      "Queen's Gambit Accepted",
      "Queen's Gambit Accepted, Classical",
      "d4 d5 c4 dxc4 Nf3 Nf6 e3 e6 Bxc4 c5 O-O a6 Qe2 b5 Bb3 Bb7",
      "rn1qkb1r/1b3ppp/p3pn2/1pp5/3P4/1B2PN2/PP2QPPP/RNB2RK1",
      "c8b7"
    ),
    "D30" -> Ecopening(
      "D30",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6",
      "rnbqkbnr/ppp2ppp/4p3/3p4/2PP4/8/PP2PPPP/RNBQKBNR",
      "e7e6"
    ),
    "D31" -> Ecopening(
      "D31",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3",
      "rnbqkbnr/ppp2ppp/4p3/3p4/2PP4/2N5/PP2PPPP/R1BQKBNR",
      "b1c3"
    ),
    "D32" -> Ecopening(
      "D32",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Tarrasch",
      "d4 d5 c4 e6 Nc3 c5",
      "rnbqkbnr/pp3ppp/4p3/2pp4/2PP4/2N5/PP2PPPP/R1BQKBNR",
      "c7c5"
    ),
    "D33" -> Ecopening(
      "D33",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Tarrasch",
      "d4 d5 c4 e6 Nc3 c5 cxd5 exd5 Nf3 Nc6 g3",
      "r1bqkbnr/pp3ppp/2n5/2pp4/3P4/2N2NP1/PP2PP1P/R1BQKB1R",
      "g2g3"
    ),
    "D34" -> Ecopening(
      "D34",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Tarrasch",
      "d4 d5 c4 e6 Nc3 c5 cxd5 exd5 Nf3 Nc6 g3 Nf6 Bg2 Be7",
      "r1bqk2r/pp2bppp/2n2n2/2pp4/3P4/2N2NP1/PP2PPBP/R1BQK2R",
      "f8e7"
    ),
    "D35" -> Ecopening(
      "D35",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3 Nf6",
      "rnbqkb1r/ppp2ppp/4pn2/3p4/2PP4/2N5/PP2PPPP/R1BQKBNR",
      "g8f6"
    ),
    "D36" -> Ecopening(
      "D36",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Exchange, Positional line, 6.Qc2",
      "d4 d5 c4 e6 Nc3 Nf6 cxd5 exd5 Bg5 c6 Qc2",
      "rnbqkb1r/pp3ppp/2p2n2/3p2B1/3P4/2N5/PPQ1PPPP/R3KBNR",
      "d1c2"
    ),
    "D37" -> Ecopening(
      "D37",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3",
      "rnbqkb1r/ppp2ppp/4pn2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R",
      "g1f3"
    ),
    "D38" -> Ecopening(
      "D38",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Ragozin Variation",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 Bb4",
      "rnbqk2r/ppp2ppp/4pn2/3p4/1bPP4/2N2N2/PP2PPPP/R1BQKB1R",
      "f8b4"
    ),
    "D39" -> Ecopening(
      "D39",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Ragozin, Vienna Variation",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 Bb4 Bg5 dxc4",
      "rnbqk2r/ppp2ppp/4pn2/6B1/1bpP4/2N2N2/PP2PPPP/R2QKB1R",
      "d5c4"
    ),
    "D40" -> Ecopening(
      "D40",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Semi-Tarrasch",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c5",
      "rnbqkb1r/pp3ppp/4pn2/2pp4/2PP4/2N2N2/PP2PPPP/R1BQKB1R",
      "c7c5"
    ),
    "D41" -> Ecopening(
      "D41",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Semi-Tarrasch",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c5 cxd5",
      "rnbqkb1r/pp3ppp/4pn2/2pP4/3P4/2N2N2/PP2PPPP/R1BQKB1R",
      "c4d5"
    ),
    "D42" -> Ecopening(
      "D42",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Semi-Tarrasch, 7.Bd3",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c5 cxd5 Nxd5 e3 Nc6 Bd3",
      "r1bqkb1r/pp3ppp/2n1p3/2pn4/3P4/2NBPN2/PP3PPP/R1BQK2R",
      "f1d3"
    ),
    "D43" -> Ecopening(
      "D43",
      "Queen's Gambit Declined Semi-Slav",
      "Queen's Gambit Declined Semi-Slav",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c6",
      "rnbqkb1r/pp3ppp/2p1pn2/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R",
      "c7c6"
    ),
    "D44" -> Ecopening(
      "D44",
      "Queen's Gambit Declined Semi-Slav",
      "Queen's Gambit Declined Semi-Slav",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c6 Bg5 dxc4",
      "rnbqkb1r/pp3ppp/2p1pn2/6B1/2pP4/2N2N2/PP2PPPP/R2QKB1R",
      "d5c4"
    ),
    "D45" -> Ecopening(
      "D45",
      "Queen's Gambit Declined Semi-Slav",
      "Queen's Gambit Declined Semi-Slav",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c6 e3",
      "rnbqkb1r/pp3ppp/2p1pn2/3p4/2PP4/2N1PN2/PP3PPP/R1BQKB1R",
      "e2e3"
    ),
    "D46" -> Ecopening(
      "D46",
      "Queen's Gambit Declined Semi-Slav",
      "Queen's Gambit Declined Semi-Slav",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c6 e3 Nbd7 Bd3",
      "r1bqkb1r/pp1n1ppp/2p1pn2/3p4/2PP4/2NBPN2/PP3PPP/R1BQK2R",
      "f1d3"
    ),
    "D47" -> Ecopening(
      "D47",
      "Queen's Gambit Declined Semi-Slav",
      "Queen's Gambit Declined Semi-Slav",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c6 e3 Nbd7 Bd3 dxc4 Bxc4",
      "r1bqkb1r/pp1n1ppp/2p1pn2/8/2BP4/2N1PN2/PP3PPP/R1BQK2R",
      "d3c4"
    ),
    "D48" -> Ecopening(
      "D48",
      "Queen's Gambit Declined Semi-Slav",
      "Queen's Gambit Declined Semi-Slav, Meran",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c6 e3 Nbd7 Bd3 dxc4 Bxc4 b5 Bd3 a6",
      "r1bqkb1r/3n1ppp/p1p1pn2/1p6/3P4/2NBPN2/PP3PPP/R1BQK2R",
      "a7a6"
    ),
    "D49" -> Ecopening(
      "D49",
      "Queen's Gambit Declined Semi-Slav",
      "Queen's Gambit Declined Semi-Slav, Meran",
      "d4 d5 c4 e6 Nc3 Nf6 Nf3 c6 e3 Nbd7 Bd3 dxc4 Bxc4 b5 Bd3 a6 e4 c5 e5 cxd4 Nxb5",
      "r1bqkb1r/3n1ppp/p3pn2/1N2P3/3p4/3B1N2/PP3PPP/R1BQK2R",
      "c3b5"
    ),
    "D50" -> Ecopening(
      "D50",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5",
      "rnbqkb1r/ppp2ppp/4pn2/3p2B1/2PP4/2N5/PP2PPPP/R2QKBNR",
      "c1g5"
    ),
    "D51" -> Ecopening(
      "D51",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Nbd7",
      "r1bqkb1r/pppn1ppp/4pn2/3p2B1/2PP4/2N5/PP2PPPP/R2QKBNR",
      "b8d7"
    ),
    "D52" -> Ecopening(
      "D52",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Nbd7 e3 c6 Nf3",
      "r1bqkb1r/pp1n1ppp/2p1pn2/3p2B1/2PP4/2N1PN2/PP3PPP/R2QKB1R",
      "g1f3"
    ),
    "D53" -> Ecopening(
      "D53",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7",
      "rnbqk2r/ppp1bppp/4pn2/3p2B1/2PP4/2N5/PP2PPPP/R2QKBNR",
      "f8e7"
    ),
    "D54" -> Ecopening(
      "D54",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Anti-Neo-Orthodox Variation",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Rc1",
      "rnbq1rk1/ppp1bppp/4pn2/3p2B1/2PP4/2N1P3/PP3PPP/2RQKBNR",
      "a1c1"
    ),
    "D55" -> Ecopening(
      "D55",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3",
      "rnbq1rk1/ppp1bppp/4pn2/3p2B1/2PP4/2N1PN2/PP3PPP/R2QKB1R",
      "g1f3"
    ),
    "D56" -> Ecopening(
      "D56",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 h6 Bh4",
      "rnbq1rk1/ppp1bpp1/4pn1p/3p4/2PP3B/2N1PN2/PP3PPP/R2QKB1R",
      "g5h4"
    ),
    "D57" -> Ecopening(
      "D57",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Lasker Defence",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 h6 Bh4 Ne4 Bxe7 Qxe7",
      "rnb2rk1/ppp1qpp1/4p2p/3p4/2PPn3/2N1PN2/PP3PPP/R2QKB1R",
      "d8e7"
    ),
    "D58" -> Ecopening(
      "D58",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Tartakower (Makagonov-Bondarevsky) Syst",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 h6 Bh4 b6",
      "rnbq1rk1/p1p1bpp1/1p2pn1p/3p4/2PP3B/2N1PN2/PP3PPP/R2QKB1R",
      "b7b6"
    ),
    "D59" -> Ecopening(
      "D59",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Tartakower",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 h6 Bh4 b6 cxd5 Nxd5",
      "rnbq1rk1/p1p1bpp1/1p2p2p/3n4/3P3B/2N1PN2/PP3PPP/R2QKB1R",
      "f6d5"
    ),
    "D60" -> Ecopening(
      "D60",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox Defence",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7",
      "r1bq1rk1/pppnbppp/4pn2/3p2B1/2PP4/2N1PN2/PP3PPP/R2QKB1R",
      "b8d7"
    ),
    "D61" -> Ecopening(
      "D61",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox, Rubinstein Attack",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Qc2",
      "r1bq1rk1/pppnbppp/4pn2/3p2B1/2PP4/2N1PN2/PPQ2PPP/R3KB1R",
      "d1c2"
    ),
    "D62" -> Ecopening(
      "D62",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox, Rubinstein Attack",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Qc2 c5 cxd5",
      "r1bq1rk1/pp1nbppp/4pn2/2pP2B1/3P4/2N1PN2/PPQ2PPP/R3KB1R",
      "c4d5"
    ),
    "D63" -> Ecopening(
      "D63",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox Defence",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Rc1",
      "r1bq1rk1/pppnbppp/4pn2/3p2B1/2PP4/2N1PN2/PP3PPP/2RQKB1R",
      "a1c1"
    ),
    "D64" -> Ecopening(
      "D64",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox, Rubinstein Attack",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Rc1 c6 Qc2",
      "r1bq1rk1/pp1nbppp/2p1pn2/3p2B1/2PP4/2N1PN2/PPQ2PPP/2R1KB1R",
      "d1c2"
    ),
    "D65" -> Ecopening(
      "D65",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox, Rubinstein Attack, Main line",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Rc1 c6 Qc2 a6 cxd5",
      "r1bq1rk1/1p1nbppp/p1p1pn2/3P2B1/3P4/2N1PN2/PPQ2PPP/2R1KB1R",
      "c4d5"
    ),
    "D66" -> Ecopening(
      "D66",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox Defence, Bd3 line",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Rc1 c6 Bd3",
      "r1bq1rk1/pp1nbppp/2p1pn2/3p2B1/2PP4/2NBPN2/PP3PPP/2RQK2R",
      "f1d3"
    ),
    "D67" -> Ecopening(
      "D67",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox Defence, Bd3 line",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Rc1 c6 Bd3 dxc4 Bxc4 Nd5",
      "r1bq1rk1/pp1nbppp/2p1p3/3n2B1/2BP4/2N1PN2/PP3PPP/2RQK2R",
      "f6d5"
    ),
    "D68" -> Ecopening(
      "D68",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox Defence, Classical",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Rc1 c6 Bd3 dxc4",
      "r1bq1rk1/pp1nbppp/2p1pn2/6B1/2pP4/2NBPN2/PP3PPP/2RQK2R",
      "d5c4"
    ),
    "D69" -> Ecopening(
      "D69",
      "Queen's Gambit Declined",
      "Queen's Gambit Declined, Orthodox Defence, Classical, 13.de",
      "d4 d5 c4 e6 Nc3 Nf6 Bg5 Be7 e3 O-O Nf3 Nbd7 Rc1 c6 Bd3 dxc4",
      "r1bq1rk1/pp1nbppp/2p1pn2/6B1/2pP4/2NBPN2/PP3PPP/2RQK2R",
      "d5c4"
    ),
    "D70" -> Ecopening(
      "D70",
      "Neo-Grunfeld Defence",
      "Neo-Grunfeld Defence",
      "d4 Nf6 c4 g6 f3 d5",
      "rnbqkb1r/ppp1pp1p/5np1/3p4/2PP4/5P2/PP2P1PP/RNBQKBNR",
      "d7d5"
    ),
    "D71" -> Ecopening(
      "D71",
      "Neo-Grunfeld",
      "Neo-Grunfeld",
      "d4 Nf6 c4 g6 g3 d5",
      "rnbqkb1r/ppp1pp1p/5np1/3p4/2PP4/6P1/PP2PP1P/RNBQKBNR",
      "d7d5"
    ),
    "D72" -> Ecopening(
      "D72",
      "Neo-Grunfeld",
      "Neo-Grunfeld, 5.cd, Main line",
      "d4 Nf6 c4 g6 g3 d5 Bg2 Bg7 cxd5 Nxd5 e4 Nb6 Ne2",
      "rnbqk2r/ppp1ppbp/1n4p1/8/3PP3/6P1/PP2NPBP/RNBQK2R",
      "g1e2"
    ),
    "D73" -> Ecopening(
      "D73",
      "Neo-Grunfeld",
      "Neo-Grunfeld, 5.Nf3",
      "d4 Nf6 c4 g6 g3 d5 Bg2 Bg7 Nf3",
      "rnbqk2r/ppp1ppbp/5np1/3p4/2PP4/5NP1/PP2PPBP/RNBQK2R",
      "g1f3"
    ),
    "D74" -> Ecopening(
      "D74",
      "Neo-Grunfeld",
      "Neo-Grunfeld, 6.cd Nxd5, 7.O-O",
      "d4 Nf6 c4 g6 g3 d5 Bg2 Bg7 Nf3 O-O cxd5 Nxd5 O-O",
      "rnbq1rk1/ppp1ppbp/6p1/3n4/3P4/5NP1/PP2PPBP/RNBQ1RK1",
      "e1g1"
    ),
    "D75" -> Ecopening(
      "D75",
      "Neo-Grunfeld",
      "Neo-Grunfeld, 6.cd Nxd5, 7.O-O c5, 8.dxc5",
      "d4 Nf6 c4 g6 g3 d5 Bg2 Bg7 Nf3 O-O cxd5 Nxd5 O-O c5 dxc5",
      "rnbq1rk1/pp2ppbp/6p1/2Pn4/8/5NP1/PP2PPBP/RNBQ1RK1",
      "d4c5"
    ),
    "D76" -> Ecopening(
      "D76",
      "Neo-Grunfeld",
      "Neo-Grunfeld, 6.cd Nxd5, 7.O-O Nb6",
      "d4 Nf6 c4 g6 g3 d5 Bg2 Bg7 Nf3 O-O cxd5 Nxd5 O-O Nb6",
      "rnbq1rk1/ppp1ppbp/1n4p1/8/3P4/5NP1/PP2PPBP/RNBQ1RK1",
      "d5b6"
    ),
    "D77" -> Ecopening(
      "D77",
      "Neo-Grunfeld",
      "Neo-Grunfeld, 6.O-O",
      "d4 Nf6 c4 g6 g3 d5 Bg2 Bg7 Nf3 O-O O-O",
      "rnbq1rk1/ppp1ppbp/5np1/3p4/2PP4/5NP1/PP2PPBP/RNBQ1RK1",
      "e1g1"
    ),
    "D78" -> Ecopening(
      "D78",
      "Neo-Grunfeld",
      "Neo-Grunfeld, 6.O-O c6",
      "d4 Nf6 c4 g6 g3 d5 Bg2 Bg7 Nf3 O-O O-O c6",
      "rnbq1rk1/pp2ppbp/2p2np1/3p4/2PP4/5NP1/PP2PPBP/RNBQ1RK1",
      "c7c6"
    ),
    "D79" -> Ecopening(
      "D79",
      "Neo-Grunfeld",
      "Neo-Grunfeld, 6.O-O, Main line",
      "d4 Nf6 c4 g6 g3 d5 Bg2 Bg7 Nf3 O-O O-O c6 cxd5 cxd5",
      "rnbq1rk1/pp2ppbp/5np1/3p4/3P4/5NP1/PP2PPBP/RNBQ1RK1",
      "c6d5"
    ),
    "D80" -> Ecopening(
      "D80",
      "Grunfeld",
      "Grunfeld",
      "d4 Nf6 c4 g6 Nc3 d5",
      "rnbqkb1r/ppp1pp1p/5np1/3p4/2PP4/2N5/PP2PPPP/R1BQKBNR",
      "d7d5"
    ),
    "D81" -> Ecopening(
      "D81",
      "Grunfeld",
      "Grunfeld, Russian Variation",
      "d4 Nf6 c4 g6 Nc3 d5 Qb3",
      "rnbqkb1r/ppp1pp1p/5np1/3p4/2PP4/1QN5/PP2PPPP/R1B1KBNR",
      "d1b3"
    ),
    "D82" -> Ecopening(
      "D82",
      "Grunfeld",
      "Grunfeld, 4.Bf4",
      "d4 Nf6 c4 g6 Nc3 d5 Bf4",
      "rnbqkb1r/ppp1pp1p/5np1/3p4/2PP1B2/2N5/PP2PPPP/R2QKBNR",
      "c1f4"
    ),
    "D83" -> Ecopening(
      "D83",
      "Grunfeld",
      "Grunfeld, Grunfeld Gambit",
      "d4 Nf6 c4 g6 Nc3 d5 Bf4 Bg7 e3 O-O",
      "rnbq1rk1/ppp1ppbp/5np1/3p4/2PP1B2/2N1P3/PP3PPP/R2QKBNR",
      "e8g8"
    ),
    "D84" -> Ecopening(
      "D84",
      "Grunfeld",
      "Grunfeld, Grunfeld Gambit Accepted",
      "d4 Nf6 c4 g6 Nc3 d5 Bf4 Bg7 e3 O-O cxd5 Nxd5 Nxd5 Qxd5 Bxc7",
      "rnb2rk1/ppB1ppbp/6p1/3q4/3P4/4P3/PP3PPP/R2QKBNR",
      "f4c7"
    ),
    "D85" -> Ecopening(
      "D85",
      "Grunfeld",
      "Grunfeld",
      "d4 Nf6 c4 g6 Nc3 d5 cxd5 Nxd5",
      "rnbqkb1r/ppp1pp1p/6p1/3n4/3P4/2N5/PP2PPPP/R1BQKBNR",
      "f6d5"
    ),
    "D86" -> Ecopening(
      "D86",
      "Grunfeld",
      "Grunfeld, Exchange",
      "d4 Nf6 c4 g6 Nc3 d5 cxd5 Nxd5 e4 Nxc3 bxc3 Bg7 Bc4",
      "rnbqk2r/ppp1ppbp/6p1/8/2BPP3/2P5/P4PPP/R1BQK1NR",
      "f1c4"
    ),
    "D87" -> Ecopening(
      "D87",
      "Grunfeld",
      "Grunfeld, Exchange",
      "d4 Nf6 c4 g6 Nc3 d5 cxd5 Nxd5 e4 Nxc3 bxc3 Bg7 Bc4 O-O Ne2 c5",
      "rnbq1rk1/pp2ppbp/6p1/2p5/2BPP3/2P5/P3NPPP/R1BQK2R",
      "c7c5"
    ),
    "D88" -> Ecopening(
      "D88",
      "Grunfeld",
      "Grunfeld, Spassky Variation, Main line, 10...cd, 11.cd",
      "d4 Nf6 c4 g6 Nc3 d5 cxd5 Nxd5 e4 Nxc3 bxc3 Bg7 Bc4 O-O Ne2",
      "rnbq1rk1/ppp1ppbp/6p1/8/2BPP3/2P5/P3NPPP/R1BQK2R",
      "g1e2"
    ),
    "D89" -> Ecopening(
      "D89",
      "Grunfeld",
      "Grunfeld",
      "d4 Nf6 c4 g6 Nc3 d5 cxd5 Nxd5 e4 Nxc3 bxc3 Bg7 Bc4 O-O Ne2",
      "rnbq1rk1/ppp1ppbp/6p1/8/2BPP3/2P5/P3NPPP/R1BQK2R",
      "g1e2"
    ),
    "D90" -> Ecopening(
      "D90",
      "Grunfeld",
      "Grunfeld",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3",
      "rnbqkb1r/ppp1pp1p/5np1/3p4/2PP4/2N2N2/PP2PPPP/R1BQKB1R",
      "g1f3"
    ),
    "D91" -> Ecopening(
      "D91",
      "Grunfeld",
      "Grunfeld, 5.Bg5",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 Bg5",
      "rnbqk2r/ppp1ppbp/5np1/3p2B1/2PP4/2N2N2/PP2PPPP/R2QKB1R",
      "c1g5"
    ),
    "D92" -> Ecopening(
      "D92",
      "Grunfeld",
      "Grunfeld, 5.Bf4",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 Bf4",
      "rnbqk2r/ppp1ppbp/5np1/3p4/2PP1B2/2N2N2/PP2PPPP/R2QKB1R",
      "c1f4"
    ),
    "D93" -> Ecopening(
      "D93",
      "Grunfeld",
      "Grunfeld, with Bf4 & e3",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 Bf4 O-O e3",
      "rnbq1rk1/ppp1ppbp/5np1/3p4/2PP1B2/2N1PN2/PP3PPP/R2QKB1R",
      "e2e3"
    ),
    "D94" -> Ecopening(
      "D94",
      "Grunfeld",
      "Grunfeld",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 e3",
      "rnbqk2r/ppp1ppbp/5np1/3p4/2PP4/2N1PN2/PP3PPP/R1BQKB1R",
      "e2e3"
    ),
    "D95" -> Ecopening(
      "D95",
      "Grunfeld",
      "Grunfeld",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 e3 O-O Qb3",
      "rnbq1rk1/ppp1ppbp/5np1/3p4/2PP4/1QN1PN2/PP3PPP/R1B1KB1R",
      "d1b3"
    ),
    "D96" -> Ecopening(
      "D96",
      "Grunfeld",
      "Grunfeld, Russian Variation",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 Qb3",
      "rnbqk2r/ppp1ppbp/5np1/3p4/2PP4/1QN2N2/PP2PPPP/R1B1KB1R",
      "d1b3"
    ),
    "D97" -> Ecopening(
      "D97",
      "Grunfeld",
      "Grunfeld, Russian",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 Qb3 dxc4 Qxc4 O-O e4",
      "rnbq1rk1/ppp1ppbp/5np1/8/2QPP3/2N2N2/PP3PPP/R1B1KB1R",
      "e2e4"
    ),
    "D98" -> Ecopening(
      "D98",
      "Grunfeld",
      "Grunfeld, Russian",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 Qb3 dxc4 Qxc4 O-O e4 Bg4",
      "rn1q1rk1/ppp1ppbp/5np1/8/2QPP1b1/2N2N2/PP3PPP/R1B1KB1R",
      "c8g4"
    ),
    "D99" -> Ecopening(
      "D99",
      "Grunfeld",
      "Grunfeld Defence, Smyslov",
      "d4 Nf6 c4 g6 Nc3 d5 Nf3 Bg7 Qb3 dxc4 Qxc4 O-O e4 Bg4 Be3",
      "rn1q1rk1/ppp1ppbp/5np1/8/2QPP1b1/2N1BN2/PP3PPP/R3KB1R",
      "c1e3"
    ),
    "E00" -> Ecopening(
      "E00",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 Nf6 c4 e6",
      "rnbqkb1r/pppp1ppp/4pn2/8/2PP4/8/PP2PPPP/RNBQKBNR",
      "e7e6"
    ),
    "E01" -> Ecopening(
      "E01",
      "Catalan",
      "Catalan, Closed",
      "d4 Nf6 c4 e6 g3 d5 Bg2",
      "rnbqkb1r/ppp2ppp/4pn2/3p4/2PP4/6P1/PP2PPBP/RNBQK1NR",
      "f1g2"
    ),
    "E02" -> Ecopening(
      "E02",
      "Catalan",
      "Catalan, Open, 5.Qa4",
      "d4 Nf6 c4 e6 g3 d5 Bg2 dxc4 Qa4+",
      "rnbqkb1r/ppp2ppp/4pn2/8/Q1pP4/6P1/PP2PPBP/RNB1K1NR",
      "d1a4"
    ),
    "E03" -> Ecopening(
      "E03",
      "Catalan",
      "Catalan, Open",
      "d4 Nf6 c4 e6 g3 d5 Bg2 dxc4 Qa4+ Nbd7 Qxc4",
      "r1bqkb1r/pppn1ppp/4pn2/8/2QP4/6P1/PP2PPBP/RNB1K1NR",
      "a4c4"
    ),
    "E04" -> Ecopening(
      "E04",
      "Catalan",
      "Catalan, Open, 5.Nf3",
      "d4 Nf6 c4 e6 g3 d5 Bg2 dxc4 Nf3",
      "rnbqkb1r/ppp2ppp/4pn2/8/2pP4/5NP1/PP2PPBP/RNBQK2R",
      "g1f3"
    ),
    "E05" -> Ecopening(
      "E05",
      "Catalan",
      "Catalan, Open, Classical line",
      "d4 Nf6 c4 e6 g3 d5 Bg2 dxc4 Nf3 Be7",
      "rnbqk2r/ppp1bppp/4pn2/8/2pP4/5NP1/PP2PPBP/RNBQK2R",
      "f8e7"
    ),
    "E06" -> Ecopening(
      "E06",
      "Catalan",
      "Catalan, Closed, 5.Nf3",
      "d4 Nf6 c4 e6 g3 d5 Bg2 Be7 Nf3",
      "rnbqk2r/ppp1bppp/4pn2/3p4/2PP4/5NP1/PP2PPBP/RNBQK2R",
      "g1f3"
    ),
    "E07" -> Ecopening(
      "E07",
      "Catalan",
      "Catalan, Closed",
      "d4 Nf6 c4 e6 g3 d5 Bg2 Be7 Nf3 O-O O-O Nbd7",
      "r1bq1rk1/pppnbppp/4pn2/3p4/2PP4/5NP1/PP2PPBP/RNBQ1RK1",
      "b8d7"
    ),
    "E08" -> Ecopening(
      "E08",
      "Catalan",
      "Catalan, Closed",
      "d4 Nf6 c4 e6 g3 d5 Bg2 Be7 Nf3 O-O O-O Nbd7 Qc2",
      "r1bq1rk1/pppnbppp/4pn2/3p4/2PP4/5NP1/PPQ1PPBP/RNB2RK1",
      "d1c2"
    ),
    "E09" -> Ecopening(
      "E09",
      "Catalan",
      "Catalan, Closed",
      "d4 Nf6 c4 e6 g3 d5 Bg2 Be7 Nf3 O-O O-O Nbd7 Qc2 c6 Nbd2",
      "r1bq1rk1/pp1nbppp/2p1pn2/3p4/2PP4/5NP1/PPQNPPBP/R1B2RK1",
      "b1d2"
    ),
    "E10" -> Ecopening(
      "E10",
      "Queen's Pawn Game",
      "Queen's Pawn Game",
      "d4 Nf6 c4 e6 Nf3",
      "rnbqkb1r/pppp1ppp/4pn2/8/2PP4/5N2/PP2PPPP/RNBQKB1R",
      "g1f3"
    ),
    "E11" -> Ecopening(
      "E11",
      "Bogo-Indian Defence",
      "Bogo-Indian Defence",
      "d4 Nf6 c4 e6 Nf3 Bb4+",
      "rnbqk2r/pppp1ppp/4pn2/8/1bPP4/5N2/PP2PPPP/RNBQKB1R",
      "f8b4"
    ),
    "E12" -> Ecopening(
      "E12",
      "Queen's Indian",
      "Queen's Indian",
      "d4 Nf6 c4 e6 Nf3 b6",
      "rnbqkb1r/p1pp1ppp/1p2pn2/8/2PP4/5N2/PP2PPPP/RNBQKB1R",
      "b7b6"
    ),
    "E13" -> Ecopening(
      "E13",
      "Queen's Indian",
      "Queen's Indian, 4.Nc3, Main line",
      "d4 Nf6 c4 e6 Nf3 b6 Nc3 Bb7 Bg5 h6 Bh4 Bb4",
      "rn1qk2r/pbpp1pp1/1p2pn1p/8/1bPP3B/2N2N2/PP2PPPP/R2QKB1R",
      "f8b4"
    ),
    "E14" -> Ecopening(
      "E14",
      "Queen's Indian",
      "Queen's Indian",
      "d4 Nf6 c4 e6 Nf3 b6 e3",
      "rnbqkb1r/p1pp1ppp/1p2pn2/8/2PP4/4PN2/PP3PPP/RNBQKB1R",
      "e2e3"
    ),
    "E15" -> Ecopening(
      "E15",
      "Queen's Indian",
      "Queen's Indian",
      "d4 Nf6 c4 e6 Nf3 b6 g3",
      "rnbqkb1r/p1pp1ppp/1p2pn2/8/2PP4/5NP1/PP2PP1P/RNBQKB1R",
      "g2g3"
    ),
    "E16" -> Ecopening(
      "E16",
      "Queen's Indian",
      "Queen's Indian",
      "d4 Nf6 c4 e6 Nf3 b6 g3 Bb7 Bg2 Bb4+",
      "rn1qk2r/pbpp1ppp/1p2pn2/8/1bPP4/5NP1/PP2PPBP/RNBQK2R",
      "f8b4"
    ),
    "E17" -> Ecopening(
      "E17",
      "Queen's Indian",
      "Queen's Indian",
      "d4 Nf6 c4 e6 Nf3 b6 g3 Bb7 Bg2 Be7",
      "rn1qk2r/pbppbppp/1p2pn2/8/2PP4/5NP1/PP2PPBP/RNBQK2R",
      "f8e7"
    ),
    "E18" -> Ecopening(
      "E18",
      "Queen's Indian",
      "Queen's Indian, Old Main line, 7.Nc3",
      "d4 Nf6 c4 e6 Nf3 b6 g3 Bb7 Bg2 Be7 O-O O-O Nc3",
      "rn1q1rk1/pbppbppp/1p2pn2/8/2PP4/2N2NP1/PP2PPBP/R1BQ1RK1",
      "b1c3"
    ),
    "E19" -> Ecopening(
      "E19",
      "Queen's Indian",
      "Queen's Indian, Old Main line, 9.Qxc3",
      "d4 Nf6 c4 e6 Nf3 b6 g3 Bb7 Bg2 Be7 O-O O-O Nc3 Ne4 Qc2 Nxc3",
      "rn1q1rk1/pbppbppp/1p2p3/8/2PP4/2n2NP1/PPQ1PPBP/R1B2RK1",
      "e4c3"
    ),
    "E20" -> Ecopening(
      "E20",
      "Nimzo-Indian",
      "Nimzo-Indian",
      "d4 Nf6 c4 e6 Nc3 Bb4",
      "rnbqk2r/pppp1ppp/4pn2/8/1bPP4/2N5/PP2PPPP/R1BQKBNR",
      "f8b4"
    ),
    "E21" -> Ecopening(
      "E21",
      "Nimzo-Indian",
      "Nimzo-Indian, Three Knights",
      "d4 Nf6 c4 e6 Nc3 Bb4 Nf3",
      "rnbqk2r/pppp1ppp/4pn2/8/1bPP4/2N2N2/PP2PPPP/R1BQKB1R",
      "g1f3"
    ),
    "E22" -> Ecopening(
      "E22",
      "Nimzo-Indian",
      "Nimzo-Indian, Spielmann Variation",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qb3",
      "rnbqk2r/pppp1ppp/4pn2/8/1bPP4/1QN5/PP2PPPP/R1B1KBNR",
      "d1b3"
    ),
    "E23" -> Ecopening(
      "E23",
      "Nimzo-Indian",
      "Nimzo-Indian, Spielmann",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qb3 c5 dxc5 Nc6",
      "r1bqk2r/pp1p1ppp/2n1pn2/2P5/1bP5/1QN5/PP2PPPP/R1B1KBNR",
      "b8c6"
    ),
    "E24" -> Ecopening(
      "E24",
      "Nimzo-Indian",
      "Nimzo-Indian, Samisch",
      "d4 Nf6 c4 e6 Nc3 Bb4 a3 Bxc3+ bxc3",
      "rnbqk2r/pppp1ppp/4pn2/8/2PP4/P1P5/4PPPP/R1BQKBNR",
      "b2c3"
    ),
    "E25" -> Ecopening(
      "E25",
      "Nimzo-Indian",
      "Nimzo-Indian, Samisch",
      "d4 Nf6 c4 e6 Nc3 Bb4 a3 Bxc3+ bxc3 c5 f3 d5 cxd5",
      "rnbqk2r/pp3ppp/4pn2/2pP4/3P4/P1P2P2/4P1PP/R1BQKBNR",
      "c4d5"
    ),
    "E26" -> Ecopening(
      "E26",
      "Nimzo-Indian",
      "Nimzo-Indian, Samisch",
      "d4 Nf6 c4 e6 Nc3 Bb4 a3 Bxc3+ bxc3 c5 e3",
      "rnbqk2r/pp1p1ppp/4pn2/2p5/2PP4/P1P1P3/5PPP/R1BQKBNR",
      "e2e3"
    ),
    "E27" -> Ecopening(
      "E27",
      "Nimzo-Indian",
      "Nimzo-Indian, Samisch Variation",
      "d4 Nf6 c4 e6 Nc3 Bb4 a3 Bxc3+ bxc3 O-O",
      "rnbq1rk1/pppp1ppp/4pn2/8/2PP4/P1P5/4PPPP/R1BQKBNR",
      "e8g8"
    ),
    "E28" -> Ecopening(
      "E28",
      "Nimzo-Indian",
      "Nimzo-Indian, Samisch Variation",
      "d4 Nf6 c4 e6 Nc3 Bb4 a3 Bxc3+ bxc3 O-O e3",
      "rnbq1rk1/pppp1ppp/4pn2/8/2PP4/P1P1P3/5PPP/R1BQKBNR",
      "e2e3"
    ),
    "E29" -> Ecopening(
      "E29",
      "Nimzo-Indian",
      "Nimzo-Indian, Samisch",
      "d4 Nf6 c4 e6 Nc3 Bb4 a3 Bxc3+ bxc3 O-O e3 c5 Bd3 Nc6",
      "r1bq1rk1/pp1p1ppp/2n1pn2/2p5/2PP4/P1PBP3/5PPP/R1BQK1NR",
      "b8c6"
    ),
    "E30" -> Ecopening(
      "E30",
      "Nimzo-Indian",
      "Nimzo-Indian, Leningrad",
      "d4 Nf6 c4 e6 Nc3 Bb4 Bg5",
      "rnbqk2r/pppp1ppp/4pn2/6B1/1bPP4/2N5/PP2PPPP/R2QKBNR",
      "c1g5"
    ),
    "E31" -> Ecopening(
      "E31",
      "Nimzo-Indian",
      "Nimzo-Indian, Leningrad, Main line",
      "d4 Nf6 c4 e6 Nc3 Bb4 Bg5 h6 Bh4 c5 d5 d6",
      "rnbqk2r/pp3pp1/3ppn1p/2pP4/1bP4B/2N5/PP2PPPP/R2QKBNR",
      "d7d6"
    ),
    "E32" -> Ecopening(
      "E32",
      "Nimzo-Indian",
      "Nimzo-Indian, Classical",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qc2",
      "rnbqk2r/pppp1ppp/4pn2/8/1bPP4/2N5/PPQ1PPPP/R1B1KBNR",
      "d1c2"
    ),
    "E33" -> Ecopening(
      "E33",
      "Nimzo-Indian",
      "Nimzo-Indian, Classical",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qc2 Nc6",
      "r1bqk2r/pppp1ppp/2n1pn2/8/1bPP4/2N5/PPQ1PPPP/R1B1KBNR",
      "b8c6"
    ),
    "E34" -> Ecopening(
      "E34",
      "Nimzo-Indian",
      "Nimzo-Indian, Classical, Noa Variation",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qc2 d5",
      "rnbqk2r/ppp2ppp/4pn2/3p4/1bPP4/2N5/PPQ1PPPP/R1B1KBNR",
      "d7d5"
    ),
    "E35" -> Ecopening(
      "E35",
      "Nimzo-Indian",
      "Nimzo-Indian, Classical, Noa Variation, 5.cd ed",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qc2 d5 cxd5 exd5",
      "rnbqk2r/ppp2ppp/5n2/3p4/1b1P4/2N5/PPQ1PPPP/R1B1KBNR",
      "e6d5"
    ),
    "E36" -> Ecopening(
      "E36",
      "Nimzo-Indian",
      "Nimzo-Indian, Classical",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qc2 d5 a3",
      "rnbqk2r/ppp2ppp/4pn2/3p4/1bPP4/P1N5/1PQ1PPPP/R1B1KBNR",
      "a2a3"
    ),
    "E37" -> Ecopening(
      "E37",
      "Nimzo-Indian",
      "Nimzo-Indian, Classical",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qc2 d5 a3 Bxc3+ Qxc3 Ne4 Qc2",
      "rnbqk2r/ppp2ppp/4p3/3p4/2PPn3/P7/1PQ1PPPP/R1B1KBNR",
      "c3c2"
    ),
    "E38" -> Ecopening(
      "E38",
      "Nimzo-Indian",
      "Nimzo-Indian, Classical, 4...c5",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qc2 c5",
      "rnbqk2r/pp1p1ppp/4pn2/2p5/1bPP4/2N5/PPQ1PPPP/R1B1KBNR",
      "c7c5"
    ),
    "E39" -> Ecopening(
      "E39",
      "Nimzo-Indian",
      "Nimzo-Indian, Classical, Pirc Variation",
      "d4 Nf6 c4 e6 Nc3 Bb4 Qc2 c5 dxc5 O-O",
      "rnbq1rk1/pp1p1ppp/4pn2/2P5/1bP5/2N5/PPQ1PPPP/R1B1KBNR",
      "e8g8"
    ),
    "E40" -> Ecopening(
      "E40",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3",
      "rnbqk2r/pppp1ppp/4pn2/8/1bPP4/2N1P3/PP3PPP/R1BQKBNR",
      "e2e3"
    ),
    "E41" -> Ecopening(
      "E41",
      "Nimzo-Indian",
      "Nimzo-Indian",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 c5",
      "rnbqk2r/pp1p1ppp/4pn2/2p5/1bPP4/2N1P3/PP3PPP/R1BQKBNR",
      "c7c5"
    ),
    "E42" -> Ecopening(
      "E42",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3 c5, 5.Ne2 (Rubinstein)",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 c5 Ne2",
      "rnbqk2r/pp1p1ppp/4pn2/2p5/1bPP4/2N1P3/PP2NPPP/R1BQKB1R",
      "g1e2"
    ),
    "E43" -> Ecopening(
      "E43",
      "Nimzo-Indian",
      "Nimzo-Indian, Fischer Variation",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 b6",
      "rnbqk2r/p1pp1ppp/1p2pn2/8/1bPP4/2N1P3/PP3PPP/R1BQKBNR",
      "b7b6"
    ),
    "E44" -> Ecopening(
      "E44",
      "Nimzo-Indian",
      "Nimzo-Indian, Fischer Variation, 5.Ne2",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 b6 Ne2",
      "rnbqk2r/p1pp1ppp/1p2pn2/8/1bPP4/2N1P3/PP2NPPP/R1BQKB1R",
      "g1e2"
    ),
    "E45" -> Ecopening(
      "E45",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Bronstein (Byrne) Variation",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 b6 Ne2 Ba6",
      "rn1qk2r/p1pp1ppp/bp2pn2/8/1bPP4/2N1P3/PP2NPPP/R1BQKB1R",
      "c8a6"
    ),
    "E46" -> Ecopening(
      "E46",
      "Nimzo-Indian",
      "Nimzo-Indian",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O",
      "rnbq1rk1/pppp1ppp/4pn2/8/1bPP4/2N1P3/PP3PPP/R1BQKBNR",
      "e8g8"
    ),
    "E47" -> Ecopening(
      "E47",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3 O-O 5.Bd3",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Bd3",
      "rnbq1rk1/pppp1ppp/4pn2/8/1bPP4/2NBP3/PP3PPP/R1BQK1NR",
      "f1d3"
    ),
    "E48" -> Ecopening(
      "E48",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3 O-O 5.Bd3 d5",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Bd3 d5",
      "rnbq1rk1/ppp2ppp/4pn2/3p4/1bPP4/2NBP3/PP3PPP/R1BQK1NR",
      "d7d5"
    ),
    "E49" -> Ecopening(
      "E49",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Botvinnik System",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Bd3 d5 a3 Bxc3+ bxc3",
      "rnbq1rk1/ppp2ppp/4pn2/3p4/2PP4/P1PBP3/5PPP/R1BQK1NR",
      "b2c3"
    ),
    "E50" -> Ecopening(
      "E50",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3 O-O 5.Nf3, without ...d5",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3",
      "rnbq1rk1/pppp1ppp/4pn2/8/1bPP4/2N1PN2/PP3PPP/R1BQKB1R",
      "g1f3"
    ),
    "E51" -> Ecopening(
      "E51",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5",
      "rnbq1rk1/ppp2ppp/4pn2/3p4/1bPP4/2N1PN2/PP3PPP/R1BQKB1R",
      "d7d5"
    ),
    "E52" -> Ecopening(
      "E52",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Main line with ...b6",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5 Bd3 b6",
      "rnbq1rk1/p1p2ppp/1p2pn2/3p4/1bPP4/2NBPN2/PP3PPP/R1BQK2R",
      "b7b6"
    ),
    "E53" -> Ecopening(
      "E53",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5 Bd3 c5",
      "rnbq1rk1/pp3ppp/4pn2/2pp4/1bPP4/2NBPN2/PP3PPP/R1BQK2R",
      "c7c5"
    ),
    "E54" -> Ecopening(
      "E54",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Gligoric System",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5 Bd3 c5 O-O dxc4 Bxc4",
      "rnbq1rk1/pp3ppp/4pn2/2p5/1bBP4/2N1PN2/PP3PPP/R1BQ1RK1",
      "d3c4"
    ),
    "E55" -> Ecopening(
      "E55",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Gligoric System, Bronstein Variation",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5 Bd3 c5 O-O dxc4 Bxc4 Nbd7",
      "r1bq1rk1/pp1n1ppp/4pn2/2p5/1bBP4/2N1PN2/PP3PPP/R1BQ1RK1",
      "b8d7"
    ),
    "E56" -> Ecopening(
      "E56",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Main line with 7...Nc6",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5 Bd3 c5 O-O Nc6",
      "r1bq1rk1/pp3ppp/2n1pn2/2pp4/1bPP4/2NBPN2/PP3PPP/R1BQ1RK1",
      "b8c6"
    ),
    "E57" -> Ecopening(
      "E57",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Main line with 8...dc and 9...cd",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5 Bd3 c5 O-O Nc6 a3 dxc4 Bxc4",
      "r1bq1rk1/pp3ppp/2n1pn2/2p5/1bBP4/P1N1PN2/1P3PPP/R1BQ1RK1",
      "d3c4"
    ),
    "E58" -> Ecopening(
      "E58",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Main line with 8...Bxc3",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5 Bd3 c5 O-O Nc6 a3 Bxc3 bxc3",
      "r1bq1rk1/pp3ppp/2n1pn2/2pp4/2PP4/P1PBPN2/5PPP/R1BQ1RK1",
      "b2c3"
    ),
    "E59" -> Ecopening(
      "E59",
      "Nimzo-Indian",
      "Nimzo-Indian, 4.e3, Main line",
      "d4 Nf6 c4 e6 Nc3 Bb4 e3 O-O Nf3 d5 Bd3 c5 O-O Nc6 a3 Bxc3 bxc3 dxc4 Bxc4",
      "r1bq1rk1/pp3ppp/2n1pn2/2p5/2BP4/P1P1PN2/5PPP/R1BQ1RK1",
      "d3c4"
    ),
    "E60" -> Ecopening(
      "E60",
      "King's Indian",
      "King's Indian Defence",
      "d4 Nf6 c4 g6",
      "rnbqkb1r/pppppp1p/5np1/8/2PP4/8/PP2PPPP/RNBQKBNR",
      "g7g6"
    ),
    "E61" -> Ecopening(
      "E61",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3",
      "rnbqkb1r/pppppp1p/5np1/8/2PP4/2N5/PP2PPPP/R1BQKBNR",
      "b1c3"
    ),
    "E62" -> Ecopening(
      "E62",
      "King's Indian",
      "King's Indian, Fianchetto",
      "d4 Nf6 c4 g6 Nc3 Bg7 Nf3 d6 g3",
      "rnbqk2r/ppp1ppbp/3p1np1/8/2PP4/2N2NP1/PP2PP1P/R1BQKB1R",
      "g2g3"
    ),
    "E63" -> Ecopening(
      "E63",
      "King's Indian",
      "King's Indian, Fianchetto, Panno Variation",
      "d4 Nf6 c4 g6 Nc3 Bg7 Nf3 d6 g3 O-O Bg2 Nc6 O-O a6",
      "r1bq1rk1/1pp1ppbp/p1np1np1/8/2PP4/2N2NP1/PP2PPBP/R1BQ1RK1",
      "a7a6"
    ),
    "E64" -> Ecopening(
      "E64",
      "King's Indian",
      "King's Indian, Fianchetto, Yugoslav System",
      "d4 Nf6 c4 g6 Nc3 Bg7 Nf3 d6 g3 O-O Bg2 c5",
      "rnbq1rk1/pp2ppbp/3p1np1/2p5/2PP4/2N2NP1/PP2PPBP/R1BQK2R",
      "c7c5"
    ),
    "E65" -> Ecopening(
      "E65",
      "King's Indian",
      "King's Indian, Fianchetto, Yugoslav, 7.O-O",
      "d4 Nf6 c4 g6 Nc3 Bg7 Nf3 d6 g3 O-O Bg2 c5 O-O",
      "rnbq1rk1/pp2ppbp/3p1np1/2p5/2PP4/2N2NP1/PP2PPBP/R1BQ1RK1",
      "e1g1"
    ),
    "E66" -> Ecopening(
      "E66",
      "King's Indian",
      "King's Indian, Fianchetto, Yugoslav Panno",
      "d4 Nf6 c4 g6 Nc3 Bg7 Nf3 d6 g3 O-O Bg2 c5 O-O Nc6 d5",
      "r1bq1rk1/pp2ppbp/2np1np1/2pP4/2P5/2N2NP1/PP2PPBP/R1BQ1RK1",
      "d4d5"
    ),
    "E67" -> Ecopening(
      "E67",
      "King's Indian",
      "King's Indian, Fianchetto",
      "d4 Nf6 c4 g6 Nc3 Bg7 Nf3 d6 g3 O-O Bg2 Nbd7",
      "r1bq1rk1/pppnppbp/3p1np1/8/2PP4/2N2NP1/PP2PPBP/R1BQK2R",
      "b8d7"
    ),
    "E68" -> Ecopening(
      "E68",
      "King's Indian",
      "King's Indian, Fianchetto, Classical Variation, 8.e4",
      "d4 Nf6 c4 g6 Nc3 Bg7 Nf3 d6 g3 O-O Bg2 Nbd7 O-O e5 e4",
      "r1bq1rk1/pppn1pbp/3p1np1/4p3/2PPP3/2N2NP1/PP3PBP/R1BQ1RK1",
      "e2e4"
    ),
    "E69" -> Ecopening(
      "E69",
      "King's Indian",
      "King's Indian, Fianchetto, Classical Main line",
      "d4 Nf6 c4 g6 Nc3 Bg7 Nf3 d6 g3 O-O Bg2 Nbd7 O-O e5 e4 c6 h3",
      "r1bq1rk1/pp1n1pbp/2pp1np1/4p3/2PPP3/2N2NPP/PP3PB1/R1BQ1RK1",
      "h2h3"
    ),
    "E70" -> Ecopening(
      "E70",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4",
      "rnbqk2r/ppppppbp/5np1/8/2PPP3/2N5/PP3PPP/R1BQKBNR",
      "e2e4"
    ),
    "E71" -> Ecopening(
      "E71",
      "King's Indian",
      "King's Indian, Makagonov System (5.h3)",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 h3",
      "rnbqk2r/ppp1ppbp/3p1np1/8/2PPP3/2N4P/PP3PP1/R1BQKBNR",
      "h2h3"
    ),
    "E72" -> Ecopening(
      "E72",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 g3",
      "rnbqk2r/ppp1ppbp/3p1np1/8/2PPP3/2N3P1/PP3P1P/R1BQKBNR",
      "g2g3"
    ),
    "E73" -> Ecopening(
      "E73",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Be2",
      "rnbqk2r/ppp1ppbp/3p1np1/8/2PPP3/2N5/PP2BPPP/R1BQK1NR",
      "f1e2"
    ),
    "E74" -> Ecopening(
      "E74",
      "King's Indian",
      "King's Indian, Averbakh, 6...c5",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Be2 O-O Bg5 c5",
      "rnbq1rk1/pp2ppbp/3p1np1/2p3B1/2PPP3/2N5/PP2BPPP/R2QK1NR",
      "c7c5"
    ),
    "E75" -> Ecopening(
      "E75",
      "King's Indian",
      "King's Indian, Averbakh, Main line",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Be2 O-O Bg5 c5 d5 e6",
      "rnbq1rk1/pp3pbp/3ppnp1/2pP2B1/2P1P3/2N5/PP2BPPP/R2QK1NR",
      "e7e6"
    ),
    "E76" -> Ecopening(
      "E76",
      "King's Indian",
      "King's Indian, Four Pawns Attack",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f4",
      "rnbqk2r/ppp1ppbp/3p1np1/8/2PPPP2/2N5/PP4PP/R1BQKBNR",
      "f2f4"
    ),
    "E77" -> Ecopening(
      "E77",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f4 O-O Be2",
      "rnbq1rk1/ppp1ppbp/3p1np1/8/2PPPP2/2N5/PP2B1PP/R1BQK1NR",
      "f1e2"
    ),
    "E78" -> Ecopening(
      "E78",
      "King's Indian",
      "King's Indian, Four Pawns Attack, with Be2 and Nf3",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f4 O-O Be2 c5 Nf3",
      "rnbq1rk1/pp2ppbp/3p1np1/2p5/2PPPP2/2N2N2/PP2B1PP/R1BQK2R",
      "g1f3"
    ),
    "E79" -> Ecopening(
      "E79",
      "King's Indian",
      "King's Indian, Four Pawns Attack, Main line",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f4 O-O Be2 c5 Nf3 cxd4 Nxd4 Nc6 Be3",
      "r1bq1rk1/pp2ppbp/2np1np1/8/2PNPP2/2N1B3/PP2B1PP/R2QK2R",
      "c1e3"
    ),
    "E80" -> Ecopening(
      "E80",
      "King's Indian",
      "King's Indian, Samisch Variation",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3",
      "rnbqk2r/ppp1ppbp/3p1np1/8/2PPP3/2N2P2/PP4PP/R1BQKBNR",
      "f2f3"
    ),
    "E81" -> Ecopening(
      "E81",
      "King's Indian",
      "King's Indian, Samisch",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O",
      "rnbq1rk1/ppp1ppbp/3p1np1/8/2PPP3/2N2P2/PP4PP/R1BQKBNR",
      "e8g8"
    ),
    "E82" -> Ecopening(
      "E82",
      "King's Indian",
      "King's Indian, Samisch, double Fianchetto Variation",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O Be3 b6",
      "rnbq1rk1/p1p1ppbp/1p1p1np1/8/2PPP3/2N1BP2/PP4PP/R2QKBNR",
      "b7b6"
    ),
    "E83" -> Ecopening(
      "E83",
      "King's Indian",
      "King's Indian, Samisch",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O Be3 Nc6",
      "r1bq1rk1/ppp1ppbp/2np1np1/8/2PPP3/2N1BP2/PP4PP/R2QKBNR",
      "b8c6"
    ),
    "E84" -> Ecopening(
      "E84",
      "King's Indian",
      "King's Indian, Samisch, Panno Main line",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O Be3 Nc6 Nge2 a6 Qd2 Rb8",
      "1rbq1rk1/1pp1ppbp/p1np1np1/8/2PPP3/2N1BP2/PP1QN1PP/R3KB1R",
      "a8b8"
    ),
    "E85" -> Ecopening(
      "E85",
      "King's Indian",
      "King's Indian, Samisch, Orthodox Variation",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O Be3 e5",
      "rnbq1rk1/ppp2pbp/3p1np1/4p3/2PPP3/2N1BP2/PP4PP/R2QKBNR",
      "e7e5"
    ),
    "E86" -> Ecopening(
      "E86",
      "King's Indian",
      "King's Indian, Samisch, Orthodox, 7.Nge2 c6",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O Be3 e5 Nge2 c6",
      "rnbq1rk1/pp3pbp/2pp1np1/4p3/2PPP3/2N1BP2/PP2N1PP/R2QKB1R",
      "c7c6"
    ),
    "E87" -> Ecopening(
      "E87",
      "King's Indian",
      "King's Indian, Samisch, Orthodox",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O Be3 e5 d5",
      "rnbq1rk1/ppp2pbp/3p1np1/3Pp3/2P1P3/2N1BP2/PP4PP/R2QKBNR",
      "d4d5"
    ),
    "E88" -> Ecopening(
      "E88",
      "King's Indian",
      "King's Indian, Samisch, Orthodox, 7.d5 c6",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O Be3 e5 d5 c6",
      "rnbq1rk1/pp3pbp/2pp1np1/3Pp3/2P1P3/2N1BP2/PP4PP/R2QKBNR",
      "c7c6"
    ),
    "E89" -> Ecopening(
      "E89",
      "King's Indian",
      "King's Indian, Samisch, Orthodox Main line",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 f3 O-O Be3 e5 d5 c6 Nge2 cxd5",
      "rnbq1rk1/pp3pbp/3p1np1/3pp3/2P1P3/2N1BP2/PP2N1PP/R2QKB1R",
      "c6d5"
    ),
    "E90" -> Ecopening(
      "E90",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3",
      "rnbqk2r/ppp1ppbp/3p1np1/8/2PPP3/2N2N2/PP3PPP/R1BQKB1R",
      "g1f3"
    ),
    "E91" -> Ecopening(
      "E91",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2",
      "rnbq1rk1/ppp1ppbp/3p1np1/8/2PPP3/2N2N2/PP2BPPP/R1BQK2R",
      "f1e2"
    ),
    "E92" -> Ecopening(
      "E92",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2 e5",
      "rnbq1rk1/ppp2pbp/3p1np1/4p3/2PPP3/2N2N2/PP2BPPP/R1BQK2R",
      "e7e5"
    ),
    "E93" -> Ecopening(
      "E93",
      "King's Indian",
      "King's Indian, Petrosian System",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2 e5 d5 Nbd7",
      "r1bq1rk1/pppn1pbp/3p1np1/3Pp3/2P1P3/2N2N2/PP2BPPP/R1BQK2R",
      "b8d7"
    ),
    "E94" -> Ecopening(
      "E94",
      "King's Indian",
      "King's Indian, Orthodox",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2 e5 O-O",
      "rnbq1rk1/ppp2pbp/3p1np1/4p3/2PPP3/2N2N2/PP2BPPP/R1BQ1RK1",
      "e1g1"
    ),
    "E95" -> Ecopening(
      "E95",
      "King's Indian",
      "King's Indian, Orthodox, 7...Nbd7, 8.Re1",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2 e5 O-O Nbd7 Re1",
      "r1bq1rk1/pppn1pbp/3p1np1/4p3/2PPP3/2N2N2/PP2BPPP/R1BQR1K1",
      "f1e1"
    ),
    "E96" -> Ecopening(
      "E96",
      "King's Indian",
      "King's Indian, Orthodox, 7...Nbd7, Main line",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2 e5 O-O Nbd7 Re1 c6 Bf1 a5",
      "r1bq1rk1/1p1n1pbp/2pp1np1/p3p3/2PPP3/2N2N2/PP3PPP/R1BQRBK1",
      "a7a5"
    ),
    "E97" -> Ecopening(
      "E97",
      "King's Indian",
      "King's Indian",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2 e5 O-O Nc6",
      "r1bq1rk1/ppp2pbp/2np1np1/4p3/2PPP3/2N2N2/PP2BPPP/R1BQ1RK1",
      "b8c6"
    ),
    "E98" -> Ecopening(
      "E98",
      "King's Indian",
      "King's Indian, Orthodox, Taimanov, 9.Ne1",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2 e5 O-O Nc6 d5 Ne7 Ne1",
      "r1bq1rk1/ppp1npbp/3p1np1/3Pp3/2P1P3/2N5/PP2BPPP/R1BQNRK1",
      "f3e1"
    ),
    "E99" -> Ecopening(
      "E99",
      "King's Indian",
      "King's Indian, Orthodox, Taimanov",
      "d4 Nf6 c4 g6 Nc3 Bg7 e4 d6 Nf3 O-O Be2 e5 O-O Nc6 d5 Ne7 Ne1 Nd7 f3 f5",
      "r1bq1rk1/pppnn1bp/3p2p1/3Ppp2/2P1P3/2N2P2/PP2B1PP/R1BQNRK1",
      "f7f5"
    )
  )
}
