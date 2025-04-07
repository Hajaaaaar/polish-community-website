variable "flavor" { default = "m1.small" }
variable "image" { default = "Debian 12 20241202" }
variable "name1" { default = "DebianMatrix" }

variable "keypair" { default = "openstackk" } # you may need to change this
variable "network" { default = "openstack1_network" }   # you need to change this

variable "pool" { default = "cscloud_private_floating" }
variable "server1_script" { default = "./project.sh" }
variable "security_description" { default = "Terraform security group" }
variable "security_name" { default = "tf_project_security" }