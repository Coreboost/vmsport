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

  config.vm.synced_folder "./", "/home/vagrant/vmsport"

  config.vm.provider "virtualbox" do |vb|
    vb.name ="openvms"
    vb.gui = true
    vb.memory = "2048"
    vb.cpus = 2
    vb.customize ["modifyvm", :id, "--vram", "64"]
    vb.customize ["modifyvm", :id, "--accelerate3d", "on"]
#   This is needed for AlphaVM to work in VirtualBox
    vb.customize ["setextradata", :id, "VBoxInternal/CPUM/CMPXCHG16B", "1"]
  end


config.proxy.http     = ENV['http_proxy']
config.proxy.https    = ENV['https_proxy']
config.proxy.no_proxy = "localhost,127.0.0.1,*.atg.se"


  config.vm.provision "shell", inline: <<-SHELL
    apt-get update
    apt-get upgrade
    apt-get install -y curl
    apt-get install -y git
#    apt-get install -y putty
    apt-get install -y gfortran
    apt-get install -y python-dev
    apt-get install -y python-pip
    pip install 'git+https://github.com/mk-fg/yapps.git#egg=yapps'
    curl --fail --silent --show-error https://storage.googleapis.com/golang/go1.5.2.linux-amd64.tar.gz | tar -C /usr/local -xzf -
    sudo sed -i '$a export PATH=$PATH:/usr/local/go/bin' /etc/profile
#    apt-get install -y gccgo-go
    apt-get install -y libtool
    apt-get install -y build-essential
    apt-get install -y autoconf
    apt-get install -y automake
    curl --fail --silent --show-error https://download.libsodium.org/libsodium/releases/libsodium-1.0.7.tar.gz | tar -C . -xzf -
    cd libsodium-1.0.7
    ./configure
    make
    make install
    cd ..
    curl --fail --silent --show-error http://download.zeromq.org/zeromq-4.1.4.tar.gz | tar -C . -xzf -
    cd zeromq-4.1.4
    ./configure
    make
    make install
    cd ..
    curl --fail --silent --show-error -o atom.deb https://atom-installer.github.com/v1.3.2/atom-amd64.deb
    dpkg -i atom.deb
  SHELL
end
