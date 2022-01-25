using System;
using System.Collections.Generic;

#nullable disable

namespace DiplomAPI.Models
{
    public partial class OrderContent
    {
        public int Id { get; set; }
        public int ProductId { get; set; }
        public int OrderId { get; set; }
        public int Quantity { get; set; }

        public virtual Product Product { get; set;}
    }
}
