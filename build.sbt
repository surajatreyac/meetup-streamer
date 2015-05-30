name := "meetup-streamer"

version := "1.0.0"

scalaVersion := "2.10.5"

scalacOptions ++= Seq("-deprecation","-unchecked","-feature")

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
	case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
	case m if m.startsWith("META-INF") => MergeStrategy.discard
	case "about.html" => MergeStrategy.rename
	case "reference.conf" => MergeStrategy.concat
	case _ => MergeStrategy.first
	}
}

test in assembly := {}
