package sbt

object Import {

  // sbt.io
  val AllPassFilter   = sbt.io.AllPassFilter
  val DirectoryFilter = sbt.io.DirectoryFilter
  type ExactFilter = sbt.io.ExactFilter
  val ExistsFileFilter = sbt.io.ExistsFileFilter
  val FileFilter       = sbt.io.FileFilter
  type FileFilter = sbt.io.FileFilter
  val GlobFilter       = sbt.io.GlobFilter
  val Hash             = sbt.io.Hash
  val HiddenFileFilter = sbt.io.HiddenFileFilter
  val IO               = sbt.io.IO
  type Mapper = sbt.io.Mapper
  val NameFilter = sbt.io.NameFilter
  type NameFilter = sbt.io.NameFilter
  val NothingFilter = sbt.io.NothingFilter
  val Path          = sbt.io.Path
  type PathExtra = sbt.io.PathExtra
  val PathFinder = sbt.io.PathFinder
  type PathFinder           = sbt.io.PathFinder
  type PathLow              = sbt.io.PathLow
  type PatternFilter        = sbt.io.PatternFilter
  type RichFile             = sbt.io.RichFile
  type SimpleFileFilter     = sbt.io.SimpleFileFilter
  type SimpleFilter         = sbt.io.SimpleFilter
  type TestError            = sbt.io.TestError
  type TestException        = sbt.io.TestException
  type TestRuntimeException = sbt.io.TestRuntimeException

  // sbt.util
  type AbstractLogger = sbt.util.AbstractLogger
  val ControlEvent = sbt.util.ControlEvent
  type ControlEvent = sbt.util.ControlEvent
  val Level = sbt.util.Level
  type Log      = sbt.util.Log
  type LogEvent = sbt.util.LogEvent
  val Logger = sbt.util.Logger
  type Logger     = sbt.util.Logger
  type SetLevel   = sbt.util.SetLevel
  type SetSuccess = sbt.util.SetSuccess
  type SetTrace   = sbt.util.SetTrace
  type Success    = sbt.util.Success
  type Trace      = sbt.util.Trace

  // sbt.internal.util
  val AList = sbt.internal.util.AList
  type AbstractRMap[K[_], V[_]] = sbt.internal.util.AbstractRMap[K, V]
  type AlreadyHandledException  = sbt.internal.util.AlreadyHandledException
  val AttributeEntry = sbt.internal.util.AttributeEntry
  type AttributeEntry[T] = sbt.internal.util.AttributeEntry[T]
  val AttributeKey = sbt.internal.util.AttributeKey
  type AttributeKey[T] = sbt.internal.util.AttributeKey[T]
  val AttributeMap = sbt.internal.util.AttributeMap
  type AttributeMap = sbt.internal.util.AttributeMap
  val Attributed = sbt.internal.util.Attributed
  type Attributed[D]       = sbt.internal.util.Attributed[D]
  type BasicCache[I, O]    = sbt.internal.util.BasicCache[I, O]
  type BasicCacheImplicits = sbt.internal.util.BasicCacheImplicits
  type BasicLogger         = sbt.internal.util.BasicLogger
  type BufferedLogger      = sbt.internal.util.BufferedLogger
  val Cache = sbt.internal.util.Cache
  type Cache[I, O] = sbt.internal.util.Cache[I, O]
  val CacheIO = sbt.internal.util.CacheIO
  type CacheImplicits = sbt.internal.util.CacheImplicits
  val ChangeReport = sbt.internal.util.ChangeReport
  type ChangeReport[T] = sbt.internal.util.ChangeReport[T]
  type Changed[O]      = sbt.internal.util.Changed[O]
  val Classes       = sbt.internal.util.Classes
  val ConsoleLogger = sbt.internal.util.ConsoleLogger
  type ConsoleLogger = sbt.internal.util.ConsoleLogger
  val ConsoleOut = sbt.internal.util.ConsoleOut
  type ConsoleOut = sbt.internal.util.ConsoleOut
  val Dag = sbt.internal.util.Dag
  type Dag[Node <: Dag[Node]]     = sbt.internal.util.Dag[Node]
  type DelegatingPMap[K[_], V[_]] = sbt.internal.util.DelegatingPMap[K, V]
  val Difference = sbt.internal.util.Difference
  type Difference           = sbt.internal.util.Difference
  type EmptyChangeReport[T] = sbt.internal.util.EmptyChangeReport[T]
  val ErrorHandling = sbt.internal.util.ErrorHandling
  type EvaluateSettings[Scope] = sbt.internal.util.EvaluateSettings[Scope]
  val EvaluationState = sbt.internal.util.EvaluationState
  val ExitHook        = sbt.internal.util.ExitHook
  type ExitHook = sbt.internal.util.ExitHook
  val ExitHooks = sbt.internal.util.ExitHooks
  type FeedbackProvidedException = sbt.internal.util.FeedbackProvidedException
  val FileFunction = sbt.internal.util.FileFunction
  val FileInfo     = sbt.internal.util.FileInfo
  type FileInfo     = sbt.internal.util.FileInfo
  type FilePosition = sbt.internal.util.FilePosition
  val FilesInfo = sbt.internal.util.FilesInfo
  type FilesInfo[F <: FileInfo] = sbt.internal.util.FilesInfo[F]
  type FilterLogger             = sbt.internal.util.FilterLogger
  type Fn1[A, B]                = sbt.internal.util.Fn1[A, B]
  val FullLogger = sbt.internal.util.FullLogger
  type FullLogger = sbt.internal.util.FullLogger
  val FullReader = sbt.internal.util.FullReader
  type FullReader = sbt.internal.util.FullReader
  val GlobalLogBacking = sbt.internal.util.GlobalLogBacking
  type GlobalLogBacking = sbt.internal.util.GlobalLogBacking
  val GlobalLogging = sbt.internal.util.GlobalLogging
  type GlobalLogging = sbt.internal.util.GlobalLogging
  val HCons = sbt.internal.util.HCons
  type HCons[H, T <: HList] = sbt.internal.util.HCons[H, T]
  val HList = sbt.internal.util.HList
  type HList               = sbt.internal.util.HList
  type HListCacheImplicits = sbt.internal.util.HListCacheImplicits
  val HNil = sbt.internal.util.HNil
  type HNil                 = sbt.internal.util.HNil
  type HashFileInfo         = sbt.internal.util.HashFileInfo
  type HashModifiedFileInfo = sbt.internal.util.HashModifiedFileInfo
  val IDSet = sbt.internal.util.IDSet
  type IDSet[T] = sbt.internal.util.IDSet[T]
  val IMap = sbt.internal.util.IMap
  type IMap[K[_], V[_]] = sbt.internal.util.IMap[K, V]
  type Init[Scope]      = sbt.internal.util.Init[Scope]
  val InputCache = sbt.internal.util.InputCache
  type InputCache[I] = sbt.internal.util.InputCache[I]
  type JLine         = sbt.internal.util.JLine
  val KCons = sbt.internal.util.KCons
  type KCons[H, +T <: KList[M], +M[_]] = sbt.internal.util.KCons[H, T, M]
  type KList[+M[_]]                    = sbt.internal.util.KList[M]
  val KNil = sbt.internal.util.KNil
  type KNil = sbt.internal.util.KNil
  val LinePosition = sbt.internal.util.LinePosition
  type LinePosition = sbt.internal.util.LinePosition
  val LineRange = sbt.internal.util.LineRange
  type LineRange  = sbt.internal.util.LineRange
  type LineReader = sbt.internal.util.LineReader
  val LoggerWriter = sbt.internal.util.LoggerWriter
  type LoggerWriter = sbt.internal.util.LoggerWriter
  val MainLogging = sbt.internal.util.MainLogging
  type MessageOnlyException = sbt.internal.util.MessageOnlyException
  type ModifiedFileInfo     = sbt.internal.util.ModifiedFileInfo
  type MultiLogger          = sbt.internal.util.MultiLogger
  val MultiLoggerConfig = sbt.internal.util.MultiLoggerConfig
  type MultiLoggerConfig = sbt.internal.util.MultiLoggerConfig
  val NoPosition = sbt.internal.util.NoPosition
  val PMap       = sbt.internal.util.PMap
  type PMap[K[_], V[_]] = sbt.internal.util.PMap[K, V]
  val Param = sbt.internal.util.Param
  type Param[A[_], B[_]] = sbt.internal.util.Param[A, B]
  type PlainFileInfo     = sbt.internal.util.PlainFileInfo
  type RMap[K[_], V[_]]  = sbt.internal.util.RMap[K, V]
  val RangePosition = sbt.internal.util.RangePosition
  type RangePosition = sbt.internal.util.RangePosition
  val Relation = sbt.internal.util.Relation
  type Relation[A, B] = sbt.internal.util.Relation[A, B]
  type SBinaryFormats = sbt.internal.util.SBinaryFormats
  val ScalaKeywords = sbt.internal.util.ScalaKeywords
  type Settings[Scope]       = sbt.internal.util.Settings[Scope]
  type SharedAttributeKey[T] = sbt.internal.util.SharedAttributeKey[T]
  val Show = sbt.internal.util.Show
  type Show[T] = sbt.internal.util.Show[T]
  val ShowLines = sbt.internal.util.ShowLines
  type ShowLines[A] = sbt.internal.util.ShowLines[A]
  val Signals      = sbt.internal.util.Signals
  val SimpleReader = sbt.internal.util.SimpleReader
  type SimpleReader   = sbt.internal.util.SimpleReader
  type SourcePosition = sbt.internal.util.SourcePosition
  val StackTrace = sbt.internal.util.StackTrace
  type SuppressedTraceContext = sbt.internal.util.SuppressedTraceContext
  type Timestamp              = sbt.internal.util.Timestamp
  val Tracked = sbt.internal.util.Tracked
  type Tracked               = sbt.internal.util.Tracked
  type TranslatedException   = sbt.internal.util.TranslatedException
  type TranslatedIOException = sbt.internal.util.TranslatedIOException
  val TypeFunctions = sbt.internal.util.TypeFunctions
  type TypeFunctions = sbt.internal.util.TypeFunctions
  val Types = sbt.internal.util.Types
  type Types                = sbt.internal.util.Types
  type UnionImplicits       = sbt.internal.util.UnionImplicits
  type UnprintableException = sbt.internal.util.UnprintableException
  val Util = sbt.internal.util.Util
  val ~>   = sbt.internal.util.~>
  type ~>[-K[_], +V[_]] = sbt.internal.util.~>[K, V]

  // sbt.internal.util.complete
  object complete {
    val Completion = sbt.internal.util.complete.Completion
    type Completion = sbt.internal.util.complete.Completion
    val Completions = sbt.internal.util.complete.Completions
    type Completions = sbt.internal.util.complete.Completions
    val DefaultParsers = sbt.internal.util.complete.DefaultParsers
    type DisplayOnly = sbt.internal.util.complete.DisplayOnly
    val EditDistance = sbt.internal.util.complete.EditDistance
    type ExampleSource = sbt.internal.util.complete.ExampleSource
    val FileExamples = sbt.internal.util.complete.FileExamples
    type FileExamples = sbt.internal.util.complete.FileExamples
    val Finite = sbt.internal.util.complete.Finite
    type Finite = sbt.internal.util.complete.Finite
    val FixedSetExamples = sbt.internal.util.complete.FixedSetExamples
    type FixedSetExamples = sbt.internal.util.complete.FixedSetExamples
    val History         = sbt.internal.util.complete.History
    val HistoryCommands = sbt.internal.util.complete.HistoryCommands
    val Infinite        = sbt.internal.util.complete.Infinite
    val JLineCompletion = sbt.internal.util.complete.JLineCompletion
    val Parser          = sbt.internal.util.complete.Parser
    type Parser[+T] = sbt.internal.util.complete.Parser[T]
    type ParserMain = sbt.internal.util.complete.ParserMain
    val Parsers = sbt.internal.util.complete.Parsers
    type Parsers = sbt.internal.util.complete.Parsers
    val ProcessError = sbt.internal.util.complete.ProcessError
    type Suggestion = sbt.internal.util.complete.Suggestion
    type Token      = sbt.internal.util.complete.Token
    val TokenCompletions = sbt.internal.util.complete.TokenCompletions
    type TokenCompletions = sbt.internal.util.complete.TokenCompletions
    val TypeString = sbt.internal.util.complete.TypeString
    type TypeString = sbt.internal.util.complete.TypeString
    val UpperBound = sbt.internal.util.complete.UpperBound
    type UpperBound = sbt.internal.util.complete.UpperBound
  }

  // sbt.internal.util.appmacro
  object appmacro {
    import scala.reflect._
    import macros._

    type BuilderResult[C <: Context with Singleton] =
      sbt.internal.util.appmacro.BuilderResult[C]
    val ContextUtil = sbt.internal.util.appmacro.ContextUtil
    type ContextUtil[C <: Context] = sbt.internal.util.appmacro.ContextUtil[C]
    type Convert                   = sbt.internal.util.appmacro.Convert
    val Converted = sbt.internal.util.appmacro.Converted
    type Converted[C <: Context with Singleton] =
      sbt.internal.util.appmacro.Converted[C]
    val Instance = sbt.internal.util.appmacro.Instance
    type Instance = sbt.internal.util.appmacro.Instance
    val KListBuilder = sbt.internal.util.appmacro.KListBuilder
    val MixedBuilder = sbt.internal.util.appmacro.MixedBuilder
    type MonadInstance = sbt.internal.util.appmacro.MonadInstance
    type TupleBuilder  = sbt.internal.util.appmacro.TupleBuilder
    val TupleNBuilder = sbt.internal.util.appmacro.TupleNBuilder
  }

  // sbt.internal.util.logic
  object logic {
    val Atom = sbt.internal.util.logic.Atom
    type Atom = sbt.internal.util.logic.Atom
    val Clause = sbt.internal.util.logic.Clause
    type Clause = sbt.internal.util.logic.Clause
    val Clauses = sbt.internal.util.logic.Clauses
    type Clauses = sbt.internal.util.logic.Clauses
    val Formula = sbt.internal.util.logic.Formula
    type Formula = sbt.internal.util.logic.Formula
    type Literal = sbt.internal.util.logic.Literal
    val Logic   = sbt.internal.util.logic.Logic
    val Negated = sbt.internal.util.logic.Negated
    type Negated = sbt.internal.util.logic.Negated
  }

  // sbt.librarymanagement
  val Artifact = sbt.librarymanagement.Artifact
  type Artifact = sbt.librarymanagement.Artifact
  val Caller = sbt.librarymanagement.Caller
  type Caller = sbt.librarymanagement.Caller
  val ChainedResolver = sbt.librarymanagement.ChainedResolver
  type ChainedResolver = sbt.librarymanagement.ChainedResolver
  val CircularDependencyLevel = sbt.librarymanagement.CircularDependencyLevel
  type CircularDependencyLevel = sbt.librarymanagement.CircularDependencyLevel
  val Configuration = sbt.librarymanagement.Configuration
  type Configuration = sbt.librarymanagement.Configuration
  val ConfigurationReport = sbt.librarymanagement.ConfigurationReport
  type ConfigurationReport = sbt.librarymanagement.ConfigurationReport
  val Configurations  = sbt.librarymanagement.Configurations
  val ConflictManager = sbt.librarymanagement.ConflictManager
  type ConflictManager = sbt.librarymanagement.ConflictManager
  val ConflictWarning = sbt.librarymanagement.ConflictWarning
  type ConflictWarning = sbt.librarymanagement.ConflictWarning
  val Credentials = sbt.librarymanagement.Credentials
  type Credentials = sbt.librarymanagement.Credentials
  val CrossVersion = sbt.librarymanagement.CrossVersion
  type CrossVersion = sbt.librarymanagement.CrossVersion
  val DefaultMavenRepository = sbt.librarymanagement.DefaultMavenRepository
  val Developer              = sbt.librarymanagement.Developer
  type Developer         = sbt.librarymanagement.Developer
  type DirectCredentials = sbt.librarymanagement.DirectCredentials
  val EvictionPair = sbt.librarymanagement.EvictionPair
  type EvictionPair = sbt.librarymanagement.EvictionPair
  val EvictionWarning = sbt.librarymanagement.EvictionWarning
  type EvictionWarning = sbt.librarymanagement.EvictionWarning
  val EvictionWarningOptions = sbt.librarymanagement.EvictionWarningOptions
  type EvictionWarningOptions = sbt.librarymanagement.EvictionWarningOptions
  val ExclusionRule = sbt.librarymanagement.ExclusionRule
  type ExclusionRule   = sbt.librarymanagement.ExclusionRule
  type FileCredentials = sbt.librarymanagement.FileCredentials
  val FileRepository = sbt.librarymanagement.FileRepository
  type FileRepository = sbt.librarymanagement.FileRepository
  val IvyScala = sbt.librarymanagement.IvyScala
  type IvyScala = sbt.librarymanagement.IvyScala
  val JCenterRepository  = sbt.librarymanagement.JCenterRepository
  val JavaNet2Repository = sbt.librarymanagement.JavaNet2Repository
  val MavenCache         = sbt.librarymanagement.MavenCache
  type MavenCache = sbt.librarymanagement.MavenCache
  val MavenRepository = sbt.librarymanagement.MavenRepository
  type MavenRepository = sbt.librarymanagement.MavenRepository
  val ModuleConfiguration = sbt.librarymanagement.ModuleConfiguration
  type ModuleConfiguration = sbt.librarymanagement.ModuleConfiguration
  val ModuleID = sbt.librarymanagement.ModuleID
  type ModuleID = sbt.librarymanagement.ModuleID
  val ModuleInfo = sbt.librarymanagement.ModuleInfo
  type ModuleInfo = sbt.librarymanagement.ModuleInfo
  val ModuleReport = sbt.librarymanagement.ModuleReport
  type ModuleReport = sbt.librarymanagement.ModuleReport
  val OrganizationArtifactReport =
    sbt.librarymanagement.OrganizationArtifactReport
  type OrganizationArtifactReport =
    sbt.librarymanagement.OrganizationArtifactReport
  val Patterns = sbt.librarymanagement.Patterns
  type Patterns                = sbt.librarymanagement.Patterns
  type PatternsBasedRepository = sbt.librarymanagement.PatternsBasedRepository
  type RawRepository           = sbt.librarymanagement.RawRepository
  val RepositoryHelpers = sbt.librarymanagement.RepositoryHelpers
  val Resolver          = sbt.librarymanagement.Resolver
  type Resolver = sbt.librarymanagement.Resolver
  val SbtArtifacts   = sbt.librarymanagement.SbtArtifacts
  val ScalaArtifacts = sbt.librarymanagement.ScalaArtifacts
  val ScalaVersion   = sbt.librarymanagement.ScalaVersion
  type ScalaVersion = sbt.librarymanagement.ScalaVersion
  val ScmInfo = sbt.librarymanagement.ScmInfo
  type ScmInfo = sbt.librarymanagement.ScmInfo
  val SftpRepository = sbt.librarymanagement.SftpRepository
  type SftpRepository     = sbt.librarymanagement.SftpRepository
  type SshBasedRepository = sbt.librarymanagement.SshBasedRepository
  val SshRepository = sbt.librarymanagement.SshRepository
  type SshRepository = sbt.librarymanagement.SshRepository
  val URLRepository = sbt.librarymanagement.URLRepository
  type URLRepository = sbt.librarymanagement.URLRepository
  val UpdateOptions = sbt.librarymanagement.UpdateOptions
  type UpdateOptions = sbt.librarymanagement.UpdateOptions
  val UpdateReport = sbt.librarymanagement.UpdateReport
  type UpdateReport = sbt.librarymanagement.UpdateReport
  val UpdateStats = sbt.librarymanagement.UpdateStats
  type UpdateStats = sbt.librarymanagement.UpdateStats
  val VersionNumber = sbt.librarymanagement.VersionNumber
  type VersionNumber = sbt.librarymanagement.VersionNumber
  type VersionNumberCompatibility =
    sbt.librarymanagement.VersionNumberCompatibility

  // sbt.internal.librarymanagement
  type ArtifactFilter = sbt.internal.librarymanagement.ArtifactFilter
  val ComponentManager = sbt.internal.librarymanagement.ComponentManager
  type ComponentManager    = sbt.internal.librarymanagement.ComponentManager
  type ConfigurationFilter = sbt.internal.librarymanagement.ConfigurationFilter
  val ConfigurationReportLite =
    sbt.internal.librarymanagement.ConfigurationReportLite
  type ConfigurationReportLite =
    sbt.internal.librarymanagement.ConfigurationReportLite
  val ConvertResolver = sbt.internal.librarymanagement.ConvertResolver
  val CustomPomParser = sbt.internal.librarymanagement.CustomPomParser
  type CustomPomParser = sbt.internal.librarymanagement.CustomPomParser
  val CustomXmlParser = sbt.internal.librarymanagement.CustomXmlParser
  type DeliverConfiguration =
    sbt.internal.librarymanagement.DeliverConfiguration
  val DependencyFilter = sbt.internal.librarymanagement.DependencyFilter
  type DependencyFilter = sbt.internal.librarymanagement.DependencyFilter
  type DependencyFilterExtra =
    sbt.internal.librarymanagement.DependencyFilterExtra
  val ExternalIvyConfiguration =
    sbt.internal.librarymanagement.ExternalIvyConfiguration
  type ExternalIvyConfiguration =
    sbt.internal.librarymanagement.ExternalIvyConfiguration
  val GetClassifiersConfiguration =
    sbt.internal.librarymanagement.GetClassifiersConfiguration
  type GetClassifiersConfiguration =
    sbt.internal.librarymanagement.GetClassifiersConfiguration
  val GetClassifiersModule =
    sbt.internal.librarymanagement.GetClassifiersModule
  type GetClassifiersModule =
    sbt.internal.librarymanagement.GetClassifiersModule
  val IfMissing = sbt.internal.librarymanagement.IfMissing
  type IfMissing      = sbt.internal.librarymanagement.IfMissing
  type ModuleSettings = sbt.internal.librarymanagement.ModuleSettings
  val InlineConfiguration = sbt.internal.librarymanagement.InlineConfiguration
  type InlineConfiguration = sbt.internal.librarymanagement.InlineConfiguration
  val InlineConfigurationWithExcludes =
    sbt.internal.librarymanagement.InlineConfigurationWithExcludes
  type InlineConfigurationWithExcludes =
    sbt.internal.librarymanagement.InlineConfigurationWithExcludes
  type InlineIvyConfiguration =
    sbt.internal.librarymanagement.InlineIvyConfiguration
  type InvalidComponent = sbt.internal.librarymanagement.InvalidComponent
  val IvyActions = sbt.internal.librarymanagement.IvyActions
  type IvyCache = sbt.internal.librarymanagement.IvyCache
  val IvyConfiguration = sbt.internal.librarymanagement.IvyConfiguration
  type IvyConfiguration = sbt.internal.librarymanagement.IvyConfiguration
  val IvyFileConfiguration =
    sbt.internal.librarymanagement.IvyFileConfiguration
  type IvyFileConfiguration =
    sbt.internal.librarymanagement.IvyFileConfiguration
  type IvyPaths = sbt.internal.librarymanagement.IvyPaths
  val IvyRetrieve = sbt.internal.librarymanagement.IvyRetrieve
  val IvySbt      = sbt.internal.librarymanagement.IvySbt
  type IvySbt = sbt.internal.librarymanagement.IvySbt
  val IvyUtil      = sbt.internal.librarymanagement.IvyUtil
  val JsonUtil     = sbt.internal.librarymanagement.JsonUtil
  val LogicalClock = sbt.internal.librarymanagement.LogicalClock
  type LogicalClock = sbt.internal.librarymanagement.LogicalClock
  val MakePom = sbt.internal.librarymanagement.MakePom
  type MakePom = sbt.internal.librarymanagement.MakePom
  val MakePomConfiguration =
    sbt.internal.librarymanagement.MakePomConfiguration
  type MakePomConfiguration =
    sbt.internal.librarymanagement.MakePomConfiguration
  type ModuleFilter = sbt.internal.librarymanagement.ModuleFilter
  type NotInCache   = sbt.internal.librarymanagement.NotInCache
  val PomConfiguration = sbt.internal.librarymanagement.PomConfiguration
  type PomConfiguration = sbt.internal.librarymanagement.PomConfiguration
  val ProjectResolver = sbt.internal.librarymanagement.ProjectResolver
  type ProjectResolver = sbt.internal.librarymanagement.ProjectResolver
  type PublishConfiguration =
    sbt.internal.librarymanagement.PublishConfiguration
  val ResolutionCache = sbt.internal.librarymanagement.ResolutionCache
  type ResolutionCache  = sbt.internal.librarymanagement.ResolutionCache
  type ResolveException = sbt.internal.librarymanagement.ResolveException
  type ResolverAdapter  = sbt.internal.librarymanagement.ResolverAdapter
  type RetrieveConfiguration =
    sbt.internal.librarymanagement.RetrieveConfiguration
  val SbtExclusionRule = sbt.internal.librarymanagement.SbtExclusionRule
  type SbtExclusionRule = sbt.internal.librarymanagement.SbtExclusionRule
  val StringUtilities   = sbt.internal.librarymanagement.StringUtilities
  val UnresolvedWarning = sbt.internal.librarymanagement.UnresolvedWarning
  type UnresolvedWarning = sbt.internal.librarymanagement.UnresolvedWarning
  val UnresolvedWarningConfiguration =
    sbt.internal.librarymanagement.UnresolvedWarningConfiguration
  type UnresolvedWarningConfiguration =
    sbt.internal.librarymanagement.UnresolvedWarningConfiguration
  type UpdateConfiguration = sbt.internal.librarymanagement.UpdateConfiguration
  val UpdateLogging    = sbt.internal.librarymanagement.UpdateLogging
  val UpdateReportLite = sbt.internal.librarymanagement.UpdateReportLite
  type UpdateReportLite = sbt.internal.librarymanagement.UpdateReportLite

  // sbt.internal.inc.classpath
  object classpath {
    type CachedClassLoader = sbt.internal.inc.classpath.CachedClassLoader
    type ClassFilter       = sbt.internal.inc.classpath.ClassFilter
    type ClassLoaderCache  = sbt.internal.inc.classpath.ClassLoaderCache
    type ClasspathFilter   = sbt.internal.inc.classpath.ClasspathFilter
    val ClasspathUtilities = sbt.internal.inc.classpath.ClasspathUtilities
    type DifferentLoaders   = sbt.internal.inc.classpath.DifferentLoaders
    type DualEnumeration[T] = sbt.internal.inc.classpath.DualEnumeration[T]
    type DualLoader         = sbt.internal.inc.classpath.DualLoader
    type ExcludePackagesFilter =
      sbt.internal.inc.classpath.ExcludePackagesFilter
    type FilteredLoader = sbt.internal.inc.classpath.FilteredLoader
    type FixedResources = sbt.internal.inc.classpath.FixedResources
    type IncludePackagesFilter =
      sbt.internal.inc.classpath.IncludePackagesFilter
    type LoaderBase       = sbt.internal.inc.classpath.LoaderBase
    type NativeCopyConfig = sbt.internal.inc.classpath.NativeCopyConfig
    type NativeCopyLoader = sbt.internal.inc.classpath.NativeCopyLoader
    type NullLoader       = sbt.internal.inc.classpath.NullLoader
    type PackageFilter    = sbt.internal.inc.classpath.PackageFilter
    type RawResources     = sbt.internal.inc.classpath.RawResources
    val RawURL = sbt.internal.inc.classpath.RawURL
    type SelfFirstLoader = sbt.internal.inc.classpath.SelfFirstLoader
  }

  type IncOptions = xsbti.compile.IncOptions
  type Analysis   = sbt.internal.inc.Analysis
  val Analysis         = sbt.internal.inc.Analysis
  val ClassfileManager = sbt.internal.inc.ClassfileManager
  type ScalaInstance = sbt.internal.inc.ScalaInstance
  val ScalaInstance = sbt.internal.inc.ScalaInstance
}
