# -*- mode: ruby -*-
# vi: set ft=ruby :

#
#  ** Add installation of Gfortran sudo apt-get install gfortran
#


Vagrant.configure(2) do |config|
  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://atlas.hashicorp.com/search.
  config.vm.box = "artem-sidorenko/mint-17.3-cinnamon"
  config.vm.network "forwarded_port", guest: 80, host: 8080
  config.vm.network "private_network", ip: "192.168.33.10"

  config.vm.synced_folder "./src", "/home/vagrant/vmsport/src"

  config.vm.provider "virtualbox" do |vb|
    vb.gui = true
    vb.memory = "2048"
  end

  config.vm.provision "shell", inline: <<-SHELL
    apt-get update
    apt-get upgrade
    apt-get install curl
    apt-get install -y gfortran
    apt-get install -y python-pip
    pip install 'git+https://github.com/mk-fg/yapps.git#egg=yapps'
    curl https://storage.googleapis.com/golang/go1.5.2.linux-amd64.tar.gz | tar -C /usr/local -xzf -
    sudo sed -i '$a export PATH=$PATH:/usr/local/go/bin' /etc/profile
    apt-get install -y gccgo-go
    apt-get install -y libtool
    apt-get install -y build-essential
    apt-get install -y autoconf
    apt-get install -y automake
    curl https://download.libsodium.org/libsodium/releases/libsodium-1.0.7.tar.gz | tar -C -xzf -
    ./configure
    make
    make install
    curl http://download.zeromq.org/zeromq-4.1.4.tar.gz | tar -C . -xzf -
    ./configure
    make
    make install
  SHELL
end
