package lila.setup

import play.api.data.Forms._
import play.api.data.format.Formats._

import chess.format.Forsyth
import chess.Mode
import lila.rating.RatingRange
import lila.lobby.Color

object Mappings {

  val variant        = number.verifying(Config.variants contains _)
  val variantWithFen = number.verifying(Config.variantsWithFen contains _)
  val aiVariants     = number.verifying(Config.aiVariants contains _)
  val variantWithVariants =
    number.verifying(Config.variantsWithVariants contains _)
  val variantWithFenAndVariants =
    number.verifying(Config.variantsWithFenAndVariants contains _)
  val time                     = of[Double].verifying(HookConfig validateTime _)
  val increment                = number.verifying(HookConfig validateIncrement _)
  val days                     = number(min = 1, max = 14)
  def timeMode                 = number.verifying(TimeMode.ids contains _)
  def mode(withRated: Boolean) = optional(rawMode(withRated))
  def rawMode(withRated: Boolean) =
    number
      .verifying(HookConfig.modes contains _)
      .verifying(m => m == Mode.Casual.id || withRated)
  val ratingRange = nonEmptyText.verifying(RatingRange valid _)
  val color       = nonEmptyText.verifying(Color.names contains _)
  val level       = number.verifying(AiConfig.levels contains _)
  val speed       = number.verifying(Config.speeds contains _)
  val fen         = optional(nonEmptyText)
}
