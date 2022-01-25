using System;
using System.Collections.Generic;

#nullable disable

namespace DiplomAPI.Models
{
    public partial class Client
    {

        public int Id { get; set; }
        public string Surname { get; set; }
        public string Name { get; set; }
        public string Middlename { get; set; }
        public string Email { get; set; }
        public string Telephone { get; set; }

    }
}
