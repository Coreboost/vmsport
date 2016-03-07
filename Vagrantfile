# -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure(2) do |config|
  config.vm.box = "artem-sidorenko/mint-17.3-cinnamon"
  config.vm.network "forwarded_port", guest: 80, host: 8080
  config.vm.network "private_network", ip: "192.168.33.10"

#  config.vm.synced_folder "./", "/home/vagrant/vmsport"

  config.vm.provider "virtualbox" do |vb|
    vb.name ="atg-svante"
    vb.gui = true
    vb.memory = "2048"
    vb.cpus = 2
    vb.customize ["modifyvm", :id, "--vram", "64"]
    vb.customize ["modifyvm", :id, "--accelerate3d", "on"]
  end

  config.proxy.http     = ENV['http_proxy']
  config.proxy.https    = ENV['https_proxy']
  config.proxy.no_proxy = "localhost,127.0.0.1,*.atg.se"

  config.vm.provision "shell" do |s|
    s.env = {'HTTP_PROXY' => ENV['http_proxy'], 'HTTPS_PROXY' => ENV['https_proxy']}
    s.inline = <<-SHELL
    echo $HTTP_PROXY
    echo $HTTPS_PROXY
    apt-get update
    apt-get upgrade
    apt-get install -y curl
    apt-get install -y git
    apt-get install -y gfortran
    apt-get remove -y openjdk*
    curl -L -O -H 'Cookie: oraclelicense=accept-securebackup-cookie' -k 'https://edelivery.oracle.com/otn-pub/java/jdk/8u73-b02/jdk-8u73-linux-i586.tar.gz'
    tar -zxvf jdk-8u73-linux-i586.tar.gz
    mkdir -p /opt/java
    mv jdk1.8.0_73 /opt/java
    update-alternatives --install '/usr/bin/java' 'java' '/opt/java/jdk1.8.0_73/bin/java' 1
    update-alternatives --set java /opt/java/jdk1.8.0_73/bin/java
    update-alternatives --install '/usr/bin/javac' 'javac' '/opt/java/jdk1.8.0_73/bin/javac' 1
    update-alternatives --set javac /opt/java/jdk1.8.0_73/bin/javac
    update-alternatives --install '/usr/bin/jar' 'jar' '/opt/java/jdk1.8.0_73/bin/jar' 1
    update-alternatives --set jar /opt/java/jdk1.8.0_73/bin/jar
    JAVA_HOME=/opt/java/jdk1.8.0_73
    export JAVA_HOME
    curl http://apache.mirrors.spacedump.net/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz | tar -C /opt/java -xzf -
    sed -i '$a export PATH=$PATH:/opt/java/apache-maven-3.3.9/bin' /etc/profile
    curl https://java.net/downloads/javacc/javacc-6.0.zip > javacc.zip
    unzip javacc.zip
    curl -sL https://deb.nodesource.com/setup_4.x | bash -
    apt-get install -y nodejs
    npm config set proxy $HTTP_PROXY
    npm config set https-proxy $HTTPS_PROXY
    npm config get proxy
    npm config get https-proxy
    apt-get install -y build-essential
#    npm install -g gulp
    apt-get install -y python-dev
    apt-get install -y python-pip
    pip install virtualenv
    pip install flask
    pip install flask-login
    pip install flask-openid
    pip install python-socketio
    pip install 'git+https://github.com/mk-fg/yapps.git#egg=yapps'
    curl --fail --silent --show-error https://storage.googleapis.com/golang/go1.5.2.linux-amd64.tar.gz | tar -C /usr/local -xzf -
    sed -i '$a export PATH=$PATH:/usr/local/go/bin' /etc/profile
    apt-get install -y libtool
    apt-get install -y build-essential
    apt-get install -y autoconf
    apt-get install -y automake
#    curl --fail --silent --show-error https://download.libsodium.org/libsodium/releases/libsodium-1.0.7.tar.gz | tar -C . -xzf -
#   cd libsodium-1.0.7
#   ./configure
#    make
#    make install
#    cd ..
#    curl --fail --silent --show-error http://download.zeromq.org/zeromq-4.1.4.tar.gz | tar -C . -xzf -
#    cd zeromq-4.1.4
#    ./configure
#    make
#    make install
#    cd ..
    curl --fail --silent --show-error -o atom.deb https://atom-installer.github.com/v1.3.2/atom-amd64.deb
    dpkg -i atom.deb
  SHELL
end
end
