require 'rubygems'

require_relative 'lib/extreme_startup/web_server'
ExtremeStartup::WebServer.run!

class String
  def blank?
    nil? || empty?
  end
end
