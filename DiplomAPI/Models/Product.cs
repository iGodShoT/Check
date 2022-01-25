using System;
using System.Collections.Generic;

#nullable disable

namespace DiplomAPI.Models
{
    public partial class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Price { get; set; }
        public int QuantityAvailable { get; set; }
    }
}
